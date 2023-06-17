package com.example.graduation.presentation.ui.bottomnavfragment

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentHomeBinding
import com.example.graduation.presentation.common.UiEffect
import com.example.graduation.presentation.ui.auth.AuthViewModel
import com.example.graduation.presentation.ui.auth.LoginDirections
import com.example.graduation.presentation.ui.history.HistoryDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : BaseFragment() {
    private val TAG = "Home"
    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }


    private val viewModel: HomeViewModel by viewModels()

    override fun getRootView(): View = binding.root
    override fun initVar() {
       // viewModel.onEvent(HomeEvent.GetLastReading)
    }

    override fun onEvent() {
        binding.run {
            tvStartReading.setOnClickListener {
                findNavController().navigate(HomeDirections.actionHome2ToReading())
            }
            imgArticle1.setOnClickListener {
                findNavController().navigate(HomeDirections.actionHome2ToArtical1())
            }
            imgArticle2.setOnClickListener {
                findNavController().navigate(HomeDirections.actionHomeToArtical2())
            }
            imgArticle3.setOnClickListener {
                findNavController().navigate(HomeDirections.actionHomeToArtical3())
            }
            person.setOnClickListener {
                findNavController().navigate(HomeDirections.actionHomeToProfile4())
            }
        }
    }


    override fun render() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                if (state.isSuccess) {
                    hideLoadingDialog()
                    Log.d(TAG, "render: ${state.lastReading}")

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