package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class AddressBody(



	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("region_id")
	val regionId: Int? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("full_address")
	val fullAddress: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)
