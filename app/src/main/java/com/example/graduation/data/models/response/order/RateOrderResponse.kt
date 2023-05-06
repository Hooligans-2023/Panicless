package com.example.graduation.data.models.response.order

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.OrderModel


data class RateOrderResponse(

	@field:SerializedName("order")
	val order: OrderModel? = null
)


