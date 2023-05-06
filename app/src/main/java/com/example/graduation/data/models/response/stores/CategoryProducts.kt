package com.example.graduation.data.models.response.stores

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate
import com.example.graduation.data.models.common.ProductModel

data class CategoryProducts(

	@field:SerializedName("products")
	val products: Products? = null
)

data class Products(

	@field:SerializedName("data")
	val data: List<ProductModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)
