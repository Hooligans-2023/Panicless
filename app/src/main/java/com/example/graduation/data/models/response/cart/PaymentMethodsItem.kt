package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName

data class PaymentMethodsItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
