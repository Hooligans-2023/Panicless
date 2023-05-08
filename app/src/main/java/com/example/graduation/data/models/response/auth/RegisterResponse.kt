package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Info
import com.example.graduation.data.models.common.UserModel

data class RegisterResponse(


	@field:SerializedName("expiry")
	val expiry: String? = null,

	@field:SerializedName("user")
	val user: UserModel? = null,

	@field:SerializedName("token")
	val token: String? = null)

data class RegisterResponseBody(

	@SerializedName("password")
	val password: String? = null,

	@SerializedName("phone")
	val phone: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("avatar")
	val avatar: String? = null,

	@SerializedName("email")
	val email: String? = null,

	@SerializedName("accept_terms_conditions")
	val acceptTermsConditions: String? = null,

	@SerializedName("info")
	val info: Info? = null
)


