package com.example.graduation.data.models.response.home

import com.google.gson.annotations.SerializedName

data class SlidersItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("show_description")
	val showDescription: Boolean? = null,

	@field:SerializedName("show_title")
	val showTitle: Boolean? = null,

	@field:SerializedName("product_id")
	val productId: Int? = null,

	@field:SerializedName("store_id")
	val storeId: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("sort")
	val sort: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
