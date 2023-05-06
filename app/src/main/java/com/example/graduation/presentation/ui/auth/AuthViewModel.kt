package com.example.graduation.presentation.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.graduation.data.repository.local.preference.LocalePreference
import com.example.graduation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.example.graduation.domain.usecase.auth.RegisterUseCase
import com.example.graduation.presentation.common.NavigationCommand
import com.example.graduation.presentation.common.UiEffect
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val localePreference: LocalePreference,
) : ViewModel() {
    private val TAG = "RegisterViewModel"
    private var _uiState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState())
    val uiState = _uiState.asStateFlow()

    private var _navigation: MutableStateFlow<NavigationCommand?> = MutableStateFlow(null)
    val navigation = _navigation.asStateFlow()

    private val _effect: Channel<UiEffect> = Channel()
    val effect = _effect.receiveAsFlow()




    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.Register -> {
                registerUseCase(event.registerBody).onEach { result ->
                    _uiState.value = when (result) {
                        is Resource.Success -> {
                            _effect.send(UiEffect.ShowToast(result.data?.message ?: ""))
                            _uiState.value.copy(isSuccess = result.data != null, registerResponse = result.data?.data, isLoading = false)
                        }
                        is Resource.Error -> {
                            val message = result.message ?: "An unexpected error occurred"
                            Log.e(TAG, "register: error message $message")
                            _effect.send(UiEffect.ShowToast(message))
                            _uiState.value.copy(error = message, isLoading = false, isSuccess = false)
                        }
                        is Resource.Loading -> {
                            _uiState.value.copy(isLoading = true, error = "", isSuccess = false)
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }

    fun navigate(navDirections: NavDirections) {
        _navigation.value = NavigationCommand.ToDirection(navDirections)
        _navigation.value = NavigationCommand.Stop
    }


    private fun saveToken(userId: String) {
        viewModelScope.launch {
            localePreference.saveToken(userId)
        }
    }



    fun clearSuccessState() {
        _uiState.value = _uiState.value.copy(isSuccess = false, isLoading = false)

    }

}