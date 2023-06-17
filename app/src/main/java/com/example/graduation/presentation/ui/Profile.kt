package com.example.graduation.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.databinding.FragmentDeepReleaseBinding
import com.example.graduation.databinding.FragmentProfileBinding
import com.example.graduation.presentation.ui.bottomnavfragment.ReliefDirections

class Profile : Fragment() {

    private val binding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.pen.setOnClickListener {
            findNavController().navigate(ProfileDirections.actionProfile4ToEditPersonFragment())

        }
        return binding.root
    }

}