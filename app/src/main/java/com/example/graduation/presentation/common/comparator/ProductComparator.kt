package com.example.graduation.presentation.common.comparator

import androidx.recyclerview.widget.DiffUtil
import com.example.graduation.data.models.common.ProductModel

object ProductComparator : DiffUtil.ItemCallback<ProductModel>() {
    override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductModel,
        newItem: ProductModel
    ): Boolean {
        return oldItem == newItem
    }
}