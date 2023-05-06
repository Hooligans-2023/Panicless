package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.ProductModel

data class ItemsCart(

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("attributes")
	val attributes: AttributesCart? = null,

	@field:SerializedName("associatedModel")
	val associatedModel: ProductModel? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("conditions")
	val conditions: List<Any?>? = null,

)