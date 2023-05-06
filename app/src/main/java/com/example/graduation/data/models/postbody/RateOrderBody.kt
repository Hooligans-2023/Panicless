package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class RateOrderBody(

    @field:SerializedName("order_id")
    val orderId: Int? = null,

    @field:SerializedName("stars")
    val stars: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,
)