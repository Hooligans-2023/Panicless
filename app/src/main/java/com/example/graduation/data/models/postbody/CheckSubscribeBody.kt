package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class CheckSubscribeBody(

    @field:SerializedName("payment_id")
    val paymentId: String? = null,

    @field:SerializedName("subscription_id")
    val subscriptionId: Int? = null,
    )

