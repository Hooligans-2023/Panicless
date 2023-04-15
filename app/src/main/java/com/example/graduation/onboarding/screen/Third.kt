package com.example.graduation.onboarding.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.graduation.R
import com.example.graduation.databinding.FragmentThirdBinding
import com.example.graduation.databinding.FragmentViewPagerBinding

class Third : Fragment() {

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewPager= activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.next3.setOnClickListener{
            findNavController().navigate(R.id.action_viewPager2_to_login)
            onBoardingFinished()
        }
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPager2_to_login)
            onBoardingFinished()

        }

        return binding.root
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}