package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class CreateReadBody(

    @field:SerializedName("heart_rate")
    val heartRate: String? = null,

    @field:SerializedName("breathing_rate")
    val breathingRate: String? = null,

    @field:SerializedName("trembling_rate")
    val tremblingRate: String? = null,

    @field:SerializedName("message")
    val message: String? = null,
    )

