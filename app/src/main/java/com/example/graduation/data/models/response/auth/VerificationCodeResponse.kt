package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.UserModel

data class VerificationCodeResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("user")
	val user: UserModel? = null
)

