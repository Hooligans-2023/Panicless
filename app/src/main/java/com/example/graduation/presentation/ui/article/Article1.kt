package com.example.graduation.presentation.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.graduation.Artical.Article1
import com.example.graduation.R
import com.example.graduation.databinding.FragmentArtical1Binding


class Article1 : Fragment() {
    private val binding by lazy {
        FragmentArtical1Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }


}