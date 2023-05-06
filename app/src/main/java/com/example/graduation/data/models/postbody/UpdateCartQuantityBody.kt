package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class UpdateCartQuantityBody(

    @field:SerializedName("item_id")
    val id: String? = null,

    @field:SerializedName("action_type")
    val actionType: String? = "update_item",

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    )
