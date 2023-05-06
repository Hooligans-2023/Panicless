package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate

data class StoreRatings(

	@field:SerializedName("data")
	val data: List<StoreRate>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)

data class StoreRate(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("stars")
	val stars: Int? = null,

	@field:SerializedName("order_id")
	val orderId: Int? = null,

	@field:SerializedName("user")
	val user: String? = null
)


