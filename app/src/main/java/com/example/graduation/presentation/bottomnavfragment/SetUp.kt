package com.example.graduation.presentation.bottomnavfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graduation.R

import com.example.graduation.databinding.FragmentSetupBinding

class SetUp : Fragment() {

    private val binding by lazy {
        FragmentSetupBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.action_home -> {
//                    // Replace the contents of the container with the HomeFragment
//                    val fragment = Home()
//                    replaceFragment(fragment)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.action_relief -> {
//                    // Replace the contents of the container with the SearchFragment
//                    val fragment = Relief()
//                    replaceFragment(fragment)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.action_predictor -> {
//                    // Replace the contents of the container with the SettingsFragment
//                    val fragment = Prediction()
//                    replaceFragment(fragment)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.action_history -> {
//                    // Replace the contents of the container with the SettingsFragment
//                    val fragment = History()
//                    replaceFragment(fragment)
//                    return@setOnNavigationItemSelectedListener true
//                }



//            }
//            false
//        }

        return binding.root
    }


// Set up the OnNavigationItemSelectedListener



    private fun replaceFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
       // transaction.replace(R.id.continer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}