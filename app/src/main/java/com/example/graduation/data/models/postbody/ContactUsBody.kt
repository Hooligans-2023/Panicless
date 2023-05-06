package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ContactUsBody(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("type")
    val type : String? = "contact",
)