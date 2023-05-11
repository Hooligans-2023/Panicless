package com.example.graduation.presentation.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.data.repository.local.preference.LocalePreference
import com.example.graduation.databinding.FragmentSplashBinding
import com.example.graduation.databinding.FragmentViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Splash : Fragment() {
    private val binding by lazy {
        FragmentSplashBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var localePreference: LocalePreference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            delay(3500)
            if (localePreference.getOnboardState() == true) {
                if (localePreference.getLoginState() == true) {
                    NavHostFragment.findNavController(this@Splash)
                        .navigate(SplashDirections.actionSplashToHome2())
                } else {
                    NavHostFragment.findNavController(this@Splash)
                        .navigate(SplashDirections.actionSplashToLogin())
                }
            }else{
                NavHostFragment.findNavController(this@Splash)
                    .navigate(SplashDirections.actionSplashToViewPager2())
            }
        }
    }


}