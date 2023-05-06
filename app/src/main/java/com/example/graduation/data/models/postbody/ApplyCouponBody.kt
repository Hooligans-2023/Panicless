package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ApplyCouponBody(

    @field:SerializedName("action_type")
    val actionType: String? = "add_coupon",

    @field:SerializedName("name")
    val coupon: String? = null,
)