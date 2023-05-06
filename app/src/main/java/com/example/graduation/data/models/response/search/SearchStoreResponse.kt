package com.example.graduation.data.models.response.search

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate
import com.example.graduation.data.models.common.ProductModel
import com.example.graduation.data.models.common.StoreModel


data class SearchStoreResponse(

	@field:SerializedName("stores")
	val stores: StoreSearch? = null
)


data class StoreSearch(

	@field:SerializedName("data")
	val data: List<StoreModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)
