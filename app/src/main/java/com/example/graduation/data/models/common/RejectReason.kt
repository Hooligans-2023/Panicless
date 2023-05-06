package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class RejectReason(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
