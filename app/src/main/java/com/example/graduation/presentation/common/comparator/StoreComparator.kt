package com.example.graduation.presentation.common.comparator

import androidx.recyclerview.widget.DiffUtil
import com.example.graduation.data.models.common.StoreModel

object StoreComparator : DiffUtil.ItemCallback<StoreModel>() {
    override fun areItemsTheSame(oldItem: StoreModel, newItem: StoreModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: StoreModel,
        newItem: StoreModel
    ): Boolean {
        return oldItem == newItem
    }
}