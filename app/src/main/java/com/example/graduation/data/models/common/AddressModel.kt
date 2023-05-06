package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class AddressModel(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("region_id")
	val regionId: Int? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("full_address")
	val fullAddress: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("is_default")
	val isDefault: Boolean? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null,

	@field:SerializedName("recipient_name")
	val recipientName: String? = null,

	@field:SerializedName("scalar")
	val scalar: String? = null

)
