package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class LoginBody(

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val password: String? = null,
)