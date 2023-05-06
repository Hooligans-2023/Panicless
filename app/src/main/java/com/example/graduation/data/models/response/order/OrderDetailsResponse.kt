package com.example.graduation.data.models.response.order

import com.example.graduation.data.models.common.AddressModel
import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.*

data class OrderDetailsResponse(

	@field:SerializedName("order")
	val order: OrderModel? = null
)



data class Addresses(

    @field:SerializedName("from")
	val from: AddressModel? = null,

    @field:SerializedName("to")
	val to: AddressModel? = null
)


