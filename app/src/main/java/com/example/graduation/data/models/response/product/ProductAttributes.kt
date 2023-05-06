package com.example.graduation.data.models.response.product

import com.google.gson.annotations.SerializedName

data class ProductAttributes(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("text")
    val text: String? = null,

    @field:SerializedName("value")
    val value: String? = null
)


