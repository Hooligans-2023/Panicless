package com.example.graduation.presentation.ui.Relief.nature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.R
import com.example.graduation.databinding.FragmentNatureBinding
import com.example.graduation.databinding.FragmentSignUpBinding

class Nature : Fragment() {
    private val binding by lazy {
        FragmentNatureBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val recyclerView:RecyclerView = binding.recycle
        recyclerView.layoutManager = LinearLayoutManager(activity)


        val myDataSet = listOf(
            MyData(R.drawable.lake, "Lake","25 min"),
            MyData(R.drawable.rain, "Thunder and rain","25 min")

        )
        val myAdapter = NatureAdapter(myDataSet)
        recyclerView.adapter = myAdapter


        return binding.root
    }


}