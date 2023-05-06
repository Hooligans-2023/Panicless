package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class SubscribeBody(

    @field:SerializedName("subscription_id")
    val subscriptionId: String? = null,
    )

