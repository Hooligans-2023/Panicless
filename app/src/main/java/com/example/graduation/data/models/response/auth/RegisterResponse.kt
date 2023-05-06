package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Info
import com.example.graduation.data.models.common.UserModel

data class RegisterResponse(

	@SerializedName("request")
	val userModel: UserModel? = null,

	@SerializedName("code")
	val code: Int? = null
)

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


