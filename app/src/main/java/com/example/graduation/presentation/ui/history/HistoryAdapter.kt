package com.example.graduation.presentation.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.R
import com.google.android.material.textview.MaterialTextView

class HistoryAdapter(private val myListHistory: List<MyHistoryData>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = myListHistory[position]

        holder.time.text = currentItem.time
        holder.numHeartBeat.text = currentItem.heartRate.toString()
        holder.numBreathing.text = currentItem.breathingRate.toString()
        holder.stateTrembling.text = currentItem.tremblingRate

    }

    override fun getItemCount() = myListHistory.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: MaterialTextView = itemView.findViewById(R.id.tvTime)
        var numHeartBeat: MaterialTextView = itemView.findViewById(R.id.numHeartBeat)
        var numBreathing: MaterialTextView = itemView.findViewById(R.id.numBreathing)
        var stateTrembling: MaterialTextView = itemView.findViewById(R.id.stateTrembling)

    }
}