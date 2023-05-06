package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class ChangePasswordBody(

    @field:SerializedName("old_password")
    val oldPassword: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("password_confirmation")
    val passwordConfirmation: String? = null,
)