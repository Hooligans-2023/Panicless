package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName

data class StoreInfos(

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("working_hours")
	val workingHours: List<WorkingHoursModel?>? = null,

	@field:SerializedName("main_address")
	val mainAddress: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("facebook")
	val facebook: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("instagram")
	val instagram: String? = null,

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("order_min_limit")
	val orderMinLimit: Double? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null,

	@field:SerializedName("is_subscribe")
	val isSubscribe: Boolean? = null
)

data class WorkingHoursModel(

	@field:SerializedName("end_at")
	val endAt: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("start_at")
	val startAt: String? = null
)
