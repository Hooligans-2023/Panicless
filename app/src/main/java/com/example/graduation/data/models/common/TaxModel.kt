package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName

data class TaxModel(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("attributes")
	val attributes: List<Any?>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("target")
	val target: String? = null,

	@field:SerializedName("order")
	val order: Int? = null


)