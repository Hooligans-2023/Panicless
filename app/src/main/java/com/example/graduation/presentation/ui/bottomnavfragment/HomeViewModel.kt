package com.example.graduation.presentation.ui.bottomnavfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.graduation.data.repository.local.preference.LocalePreference
import com.example.graduation.domain.usecase.auth.LoginUseCase
import com.example.graduation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.example.graduation.domain.usecase.auth.RegisterUseCase
import com.example.graduation.domain.usecase.main_app.CreateReadingUseCase
import com.example.graduation.domain.usecase.main_app.GetLastReadingUseCase
import com.example.graduation.domain.usecase.main_app.GetListReadingUseCase
import com.example.graduation.presentation.common.NavigationCommand
import com.example.graduation.presentation.common.UiEffect
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createReadingUseCase: CreateReadingUseCase,
    private val getLastReadingUseCase: GetLastReadingUseCase,
    private val getListReadingUseCase: GetListReadingUseCase,
    private val localePreference: LocalePreference,
) : ViewModel() {
    private val TAG = "RegisterViewModel"
    private var _uiState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    private var _navigation: MutableStateFlow<NavigationCommand?> = MutableStateFlow(null)
    val navigation = _navigation.asStateFlow()

    private val _effect: Channel<UiEffect> = Channel()
    val effect = _effect.receiveAsFlow()




    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.CreateReading -> {
                createReadingUseCase(event.createReadBody).onEach { result ->
                    _uiState.value = when (result) {
                        is Resource.Success -> {
                            _effect.send(UiEffect.ShowToast(result.message ?: ""))
                            _uiState.value.copy(isSuccess = result.data != null, createReading = result.data, isLoading = false)
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
            is HomeEvent.GetLastReading -> {
                getLastReadingUseCase().onEach { result ->
                    _uiState.value = when (result) {
                        is Resource.Success -> {
                            _effect.send(UiEffect.ShowToast(result.message ?: ""))
                            _uiState.value.copy(isSuccess = result.data != null, lastReading = result.data, isLoading = false)
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
            is HomeEvent.GetListReading -> {
                getListReadingUseCase().onEach { result ->
                    _uiState.value = when (result) {
                        is Resource.Success -> {
                            _effect.send(UiEffect.ShowToast(result.message ?: ""))
                            _uiState.value.copy(isSuccess = result.data != null, listReading = result.data, isLoading = false)
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