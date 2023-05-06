package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.response.product.AdditionsItem
import com.example.graduation.data.models.response.product.ProductAttributes
import com.example.graduation.data.models.response.product.VariationsItem

data class ProductModel(

    @field:SerializedName("feature_image")
    val featureImage: String? = null,

    @field:SerializedName("is_favorite")
    val isFavorite: Boolean,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("price_after_discount")
    val priceAfterDiscount: Double? = null,

    @field:SerializedName("views")
    val views: Int? = null,

    @field:SerializedName("selected_variation_id")
    val selectedVariationId: Int? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("stock_track")
    val stockTrack: Boolean? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("able_to_refund")
    val ableToRefund: Boolean? = null,

    @field:SerializedName("points_given")
    val pointsGiven: Int? = null,

    @field:SerializedName("points_to_buy")
    val pointsToBuy: Int? = null,

    @field:SerializedName("additions")
    val additions: List<AdditionsItem?>? = null,

    @field:SerializedName("variations")
    val variations: List<VariationsItem?>? = null,

    @field:SerializedName("attributes")
    val attributes: List<ProductAttributes?>? = null,


    )