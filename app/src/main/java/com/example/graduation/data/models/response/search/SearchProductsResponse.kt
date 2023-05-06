package com.example.graduation.data.models.response.search

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate
import com.example.graduation.data.models.common.ProductModel


data class SearchProductsResponse(

	@field:SerializedName("similar_products")
	val similarProducts: SimilarProducts? = null
)


data class SimilarProducts(

	@field:SerializedName("data")
	val data: List<ProductModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)
