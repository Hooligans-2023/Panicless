package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName

data class CartConditionActionsResponse(

	@field:SerializedName("add_coupon")
	val addCoupon: String? = null,

	@field:SerializedName("remove_coupon")
	val removeCoupon: String? = null
)
