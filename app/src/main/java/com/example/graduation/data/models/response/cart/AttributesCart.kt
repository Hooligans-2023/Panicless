package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName

data class AttributesCart(

	@field:SerializedName("additional_information")
	val additionalInformation: List<AdditionalInformationItem?>? = null,

	@field:SerializedName("additions")
	val additions: List<Any?>? = null
)