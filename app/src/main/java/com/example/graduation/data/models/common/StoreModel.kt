package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class StoreModel(

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("distance_in_km")
    val distanceInKm: Double? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("category_icon")
    val categoryIcon: String? = null,


    @field:SerializedName("rating")
    val rating: Double? = null,


    @field:SerializedName("people")
    val people: Int? = null,

    @field:SerializedName("time_to_prepare")
    val timeToPrepare: Int? = null,

    @field:SerializedName("wallet_balande")
    val walletBalance: Int? = null,

    @field:SerializedName("high_recommended")
    val highRecommended: Boolean? = null,
)