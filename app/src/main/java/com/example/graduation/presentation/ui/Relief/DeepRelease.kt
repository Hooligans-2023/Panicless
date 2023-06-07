package com.example.graduation.presentation.ui.Relief

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.databinding.FragmentDeepReleaseBinding


class DeepRelease : Fragment() {

    private val binding by lazy {
        FragmentDeepReleaseBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.btnPause.setOnClickListener{
            findNavController().navigate(DeepReleaseDirections.actionDeepReleaseToMediaFragment())

        }
        return binding.root
    }



}