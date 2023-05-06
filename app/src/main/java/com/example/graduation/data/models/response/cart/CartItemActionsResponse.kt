package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName

data class CartItemActionsResponse(

	@field:SerializedName("add_item")
	val addItem: String? = null,

	@field:SerializedName("update_item")
	val updateItem: String? = null,

	@field:SerializedName("remove_item")
	val removeItem: String? = null
)
