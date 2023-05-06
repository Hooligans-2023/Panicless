package com.example.graduation.presentation.common.comparator

import androidx.recyclerview.widget.DiffUtil
import com.example.graduation.data.models.common.OrderModel
import com.example.graduation.data.models.common.StoreModel

object OrderComparator : DiffUtil.ItemCallback<OrderModel>() {
    override fun areItemsTheSame(oldItem: OrderModel, newItem: OrderModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: OrderModel,
        newItem: OrderModel
    ): Boolean {
        return oldItem == newItem
    }
}