package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName

data class ForgetPasswordRestResponse(

	@field:SerializedName("reset_token")
	val resetToken: String? = null
)
