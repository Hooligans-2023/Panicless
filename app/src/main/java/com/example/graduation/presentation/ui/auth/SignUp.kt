package com.example.graduation.presentation.ui.auth

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.graduation.base.BaseFragment
import com.example.graduation.data.models.postbody.RegisterBody
import com.example.graduation.databinding.FragmentSignUpBinding
import com.example.graduation.presentation.common.UiEffect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUp : BaseFragment() {
    private val TAG = "SignUp"
    private val binding by lazy {
        FragmentSignUpBinding.inflate(layoutInflater)
    }

    private val viewModel: AuthViewModel by viewModels()

    override fun getRootView(): View = binding.root
    override fun initVar() {
    }

    override fun onEvent() {
        binding.run {
            signUpbtn.setOnClickListener {
                viewModel.onEvent(AuthEvent.Register(
                    RegisterBody(
                        firstName =firstNum.text.toString(),
                        lastName = lastname.text.toString(),
                        email = email.text.toString(),
                        password = pass.text.toString(),
                        trustNumber = lastNum.text.toString()
                    )
                ))
            }
            logIn.setOnClickListener {
                findNavController().navigate(SignUpDirections.actionSignUp2ToLogin())
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
                    findNavController().navigate(SignUpDirections.actionSignUp2ToHome(

                    ))
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