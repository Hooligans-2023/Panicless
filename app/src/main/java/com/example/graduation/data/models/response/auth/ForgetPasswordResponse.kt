package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName


data class ForgetPasswordResponse(

	@field:SerializedName("code")
	val code: Int? = null
)
