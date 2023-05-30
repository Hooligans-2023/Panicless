package com.example.graduation.data.models.response.reading

import com.google.gson.annotations.SerializedName

data class ReadingResponse(

	@field:SerializedName("breathing_rate")
	val breathingRate: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("heart_rate")
	val heartRate: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("trembling_rate")
	val tremblingRate: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: Int? = null
)
