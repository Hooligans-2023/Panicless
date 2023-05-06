package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.TaxModel

data class ConditionsCart(

	@field:SerializedName("Tax")
	val tax: TaxModel? = null
)
