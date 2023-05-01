package com.example.graduation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.databinding.FragmentSignUpBinding
import com.example.graduation.databinding.FragmentSplashBinding


class SignUp : Fragment() {
    private val binding by lazy {
        FragmentSignUpBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.logIn.setOnClickListener {
            findNavController().navigate(R.id.action_signUp2_to_login)

        }

        return binding.root
    }

}