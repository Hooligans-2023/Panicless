package com.example.graduation.presentation.ui.bottomnavfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.base.BaseFragment
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.databinding.FragmentHomeBinding
import com.example.graduation.databinding.FragmentSignUpBinding
import com.example.graduation.presentation.common.UiEffect
import com.example.graduation.presentation.ui.auth.AuthEvent
import com.example.graduation.presentation.ui.auth.AuthViewModel
import com.example.graduation.presentation.ui.auth.LoginDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : BaseFragment() {
    private val TAG = "Home"
    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }



private val viewModel: AuthViewModel by viewModels()

override fun getRootView(): View = binding.root
override fun initVar() {

}

override fun onEvent() {
    binding.run {
        tvStartReading.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHome2ToReading())
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