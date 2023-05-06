package com.example.graduation.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graduation.databinding.FragmentViewPagerBinding
import com.example.graduation.presentation.ui.onboarding.screen.First
import com.example.graduation.presentation.ui.onboarding.screen.Second
import com.example.graduation.presentation.ui.onboarding.screen.Third


class ViewPager : Fragment() {


    private val binding by lazy {
        FragmentViewPagerBinding.inflate(layoutInflater)
    }



    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        val listOfFragment= arrayListOf<Fragment>(

            First(),
            Second(),
            Third()
        )


        val adapter=
            ViewPagerAdapter(listOfFragment,requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter=adapter
        return binding.root
    }


}