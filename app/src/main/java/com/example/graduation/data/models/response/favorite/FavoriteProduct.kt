package com.example.graduation.data.models.response.favorite

import com.google.gson.annotations.SerializedName

data class FavoriteProduct(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("product_id")
	val productId: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("isFavorite")
	val isFavorite: Boolean? = null
)


