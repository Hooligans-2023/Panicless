package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Info

data class AccountInfoBody(


    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,


    @field:SerializedName("info")
    val info: Info? = null,

)