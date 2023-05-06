package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class Info(

	@field:SerializedName("birthday")
	val birthday: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null
)