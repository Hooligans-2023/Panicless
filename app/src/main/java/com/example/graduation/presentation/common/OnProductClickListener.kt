package com.example.graduation.presentation.common

import com.example.graduation.data.models.common.ProductModel

interface OnProductClickListener {
    fun onCategoryClickListener(product: ProductModel)

    fun onFavoriteClickListener(productId: Int, isFavorite: Boolean)

}