package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName

data class NewPasswordResponse(

	@field:SerializedName("access_token")
	val accessToken: String? = null
)
