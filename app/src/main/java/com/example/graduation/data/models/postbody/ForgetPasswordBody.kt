package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ForgetPasswordBody(

    @field:SerializedName("email")
    val emailOrPhone: String? = null,

)