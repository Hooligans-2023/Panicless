package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.StoreModel


data class StoreDetailsResponse(

	@field:SerializedName("is_busy")
	val isBusy: Boolean? = null,

	@field:SerializedName("store")
	val store: StoreModel? = null,

	@field:SerializedName("is_closed")
	val isClosed: Boolean? = null,

	@field:SerializedName("product_categories")
	val storeCategories: List<StoreCategoryProducts>?  = null,

	@field:SerializedName("store_infos")
	val storeInfos: StoreInfos? = null,

	@field:SerializedName("orders_ratings")
	val storeRatings: StoreRatings? = null,
)
