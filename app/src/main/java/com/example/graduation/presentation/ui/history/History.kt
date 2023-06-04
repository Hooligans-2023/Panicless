package com.example.graduation.presentation.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.R
import com.example.graduation.databinding.FragmentHistoryBinding
import com.example.graduation.databinding.FragmentNatureBinding
import com.example.graduation.presentation.ui.Relief.nature.MyData
import com.example.graduation.presentation.ui.Relief.nature.NatureAdapter

class History : Fragment() {

    private val binding by lazy {
        FragmentHistoryBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val recyclerView: RecyclerView = binding.recycleHistory
        recyclerView.layoutManager = LinearLayoutManager(activity)


        var myHistoryData = listOf(
            MyHistoryData( 80, 0.5," danger" , "16 hours ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago"),
            MyHistoryData( 100, 0.3," danger" , "one day ago")



        )
        val myAdapter = HistoryAdapter(myHistoryData)
        recyclerView.adapter = myAdapter


        return binding.root
    }


}