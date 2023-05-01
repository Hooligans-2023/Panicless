package com.example.graduation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.databinding.FragmentLoginBinding
import com.example.graduation.databinding.FragmentSignUpBinding

class Login : Fragment() {
    private val binding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signUp2)
        }
        return binding.root
    }


}