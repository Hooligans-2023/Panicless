package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Info

data class SubmitRegisterBody(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("password_confirmation")
	val passwordConfirmation: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("accept_terms_conditions")
	val acceptTermsConditions: String? = null,

	@field:SerializedName("info")
	val info: Info? = null
)

