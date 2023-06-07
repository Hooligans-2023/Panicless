package com.example.graduation.presentation.ui.bottomnavfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.databinding.FragmentHomeBinding
import com.example.graduation.databinding.FragmentReliefBinding

class Relief : Fragment() {
    private val binding by lazy {
        FragmentReliefBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.deep.setOnClickListener {
            findNavController().navigate(ReliefDirections.actionReliefToDeepRelease())
        }
        binding.natureCard.setOnClickListener {
            findNavController().navigate(ReliefDirections.actionReliefToNature())
        }
        binding.person.setOnClickListener {
            findNavController().navigate(ReliefDirections.actionReliefToProfile4())

        }
        return binding.root
    }

}