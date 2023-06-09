package com.example.graduation.presentation.ui.onboarding.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.graduation.R
import com.example.graduation.data.repository.local.preference.LocalePreference
import com.example.graduation.databinding.FragmentSecondBinding
import com.example.graduation.databinding.FragmentViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Second : Fragment() {

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var localePreference: LocalePreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewPager= activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.next2.setOnClickListener{
            viewPager?.currentItem=2

        }
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPager2_to_login)
            onBoardingFinished()

        }


        return binding.root
    }
    private fun onBoardingFinished(){
        lifecycleScope.launch {
        localePreference.saveOnboard(true)
    }
    }



}