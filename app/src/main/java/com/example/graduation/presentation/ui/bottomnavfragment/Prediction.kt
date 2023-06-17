package com.example.graduation.presentation.ui.bottomnavfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentChatBotBinding
import com.example.graduation.databinding.FragmentPredictionBinding


class Prediction : BaseFragment() {
    private val binding by lazy {
        FragmentPredictionBinding.inflate(layoutInflater)
    }



    override fun getRootView(): View = binding.root


    override fun initVar() {
    }

    override fun onEvent() {
        binding.start.setOnClickListener {
            findNavController().navigate(PredictionDirections.actionPredictionToChatBot())
        }
    }

    override fun render() {
    }

    override fun navigate() {
    }

    override fun showEffect() {
    }


}