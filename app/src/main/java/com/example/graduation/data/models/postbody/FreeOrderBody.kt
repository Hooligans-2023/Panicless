package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class FreeOrderBody(

    @field:SerializedName("latitude")
    val latitude: String? = null,

    @field:SerializedName("longitude")
    val longitude: String? = null,

    @field:SerializedName("free_order")
    val freeOrder: String? = null,

    @field:SerializedName("full_address")
    val fullAddress: String? = null,
)