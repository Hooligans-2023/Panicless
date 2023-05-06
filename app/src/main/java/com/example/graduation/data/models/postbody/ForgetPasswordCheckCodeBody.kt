package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ForgetPasswordCheckCodeBody(

    @field:SerializedName("email")
    val emailOrPhone: String? = null,

    @field:SerializedName("code")
    val code: String? = null,

)