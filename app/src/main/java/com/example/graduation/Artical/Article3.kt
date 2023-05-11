package com.example.graduation.Artical
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.graduation.R
import com.example.graduation.databinding.FragmentArtical3Binding

class Article3 : Fragment() {
    private val binding by lazy {
        FragmentArtical3Binding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.toolbar.setOnClickListener {
            findNavController().navigate(R.id.action_artical2_to_home)
        }
        return binding.root
    }


}