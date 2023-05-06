package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Info

data class RegisterBody(


    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("lastName")
    val lastName: String? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("trustNumber")
    val trustNumber: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

)

