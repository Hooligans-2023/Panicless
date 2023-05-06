package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName


data class StoreCategoryProducts(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)

