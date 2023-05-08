package com.example.graduation.presentation.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.base.BaseFragment
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.data.models.postbody.RegisterBody
import com.example.graduation.databinding.FragmentLoginBinding
import com.example.graduation.presentation.common.UiEffect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Login : BaseFragment() {
    private val TAG = "Login"
    private val binding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: AuthViewModel by viewModels()

    override fun getRootView(): View = binding.root
    override fun initVar() {
    }

    override fun onEvent() {
        binding.run {
            next1.setOnClickListener {
                viewModel.onEvent(AuthEvent.Login(
                    LoginBody(
                        email = firstNum.text.toString(),
                        password = pass.text.toString(),
                    )
                ))
            }

            signUp.setOnClickListener {
                findNavController().navigate(R.id.action_login_to_signUp2)
            }
        }
    }

    override fun render() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                if (state.isSuccess) {
                    hideLoadingDialog()
//                    sharedViewModel.setRegisterData(state)
//                    sharedViewModel.setCode(state.result?.code)
                    findNavController().navigate(LoginDirections.actionLoginToHome())
                    viewModel.clearSuccessState()
                }
                if (state.isLoading) {
                    showLoadingDialog()
                } else {
                    hideLoadingDialog()
                }
                if (state.error.isNotBlank()) {
                    //showToast(state.error)
                    hideLoadingDialog()
                }
            }
        }
    }

    override fun navigate() {

    }

    override fun showEffect() {
        lifecycleScope.launch {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is UiEffect.ShowToast -> {
                        Log.d(TAG, "showEffect: ${effect.message}")
                        showToast(effect.message)
                    }
                }

            }
        }
    }

}