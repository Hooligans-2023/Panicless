package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.StoreModel



data class StoresCategoriesResponse(

	@field:SerializedName("store_category")
	val storeCategory: StoreCategory? = null
)
