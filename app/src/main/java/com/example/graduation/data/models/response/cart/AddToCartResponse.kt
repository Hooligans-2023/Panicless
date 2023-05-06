package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.ProductModel


data class AddToCartResponse(

	@field:SerializedName("sub_total_without_conditions")
	val subTotalWithoutConditions: Double? = null,

	@field:SerializedName("total")
	val total: Double? = null,

	@field:SerializedName("sup_total_with_conditions")
	val supTotalWithConditions: Double? = null,

	@field:SerializedName("total_conditions")
	val totalConditions: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("total_quantity")
	val totalQuantity: Int? = null,

	@field:SerializedName("conditions")
	val conditions: ConditionsCart? = null,

	@field:SerializedName("items")
	val items: List<ItemsCart?>? = null,

	@field:SerializedName("key")
	val key: String? = null
)


data class AdditionalInformationItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)


