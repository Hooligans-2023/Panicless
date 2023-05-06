package com.example.graduation.data.models.response.order

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.OrderModel
import com.example.graduation.data.models.common.Paginate

data class MyOrdersResponse(

	@field:SerializedName("orders")
	val orders: Orders? = null
)

data class Orders(

	@field:SerializedName("data")
	val data: List<OrderModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)


