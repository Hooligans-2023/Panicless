package com.example.graduation.data.models.response.product

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate
import com.example.graduation.data.models.common.ProductModel

data class OfferProductsResponse(

	@field:SerializedName("products")
	val products: OfferProducts? = null
)

data class OfferProducts(

	@field:SerializedName("data")
	val data: List<ProductModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)



