package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class UserModel(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("trustNumber")
	val trustNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("is_admin")
	val isAdmin: Boolean? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("email")
	val email: String? = null
)


