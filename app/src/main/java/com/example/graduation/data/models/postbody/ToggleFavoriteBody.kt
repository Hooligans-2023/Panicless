package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ToggleFavoriteBody(

    @field:SerializedName("product_id")
    val productId: String? = null,
    ){

}