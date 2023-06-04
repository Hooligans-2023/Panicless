package com.example.graduation.presentation.ui.Relief.nature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.R
import com.google.android.material.imageview.ShapeableImageView

class NatureAdapter(private val myDataSet: List<MyData>):RecyclerView.Adapter<NatureAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_relief, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = myDataSet[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textTitle.text = currentItem.text
        holder.time.text = currentItem.time


    }

    override fun getItemCount()=myDataSet.size


     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val textTitle: TextView = itemView.findViewById(R.id.text_view_text)
        val time: TextView = itemView.findViewById(R.id.text_view_time)

    }
}