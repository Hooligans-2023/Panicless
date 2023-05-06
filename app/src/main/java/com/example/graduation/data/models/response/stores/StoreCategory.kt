package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.StoreModel

data class StoreCategory(

	@field:SerializedName("stores")
	val stores: List<StoreModel?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
