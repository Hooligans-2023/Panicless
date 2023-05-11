package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.UserModel

data class LoginResponse(

	@field:SerializedName("expiry")
	val expiry: String? = null,

	@field:SerializedName("user")
	val user: UserModel? = null,

	@field:SerializedName("token")
	val token: String? = null
)


