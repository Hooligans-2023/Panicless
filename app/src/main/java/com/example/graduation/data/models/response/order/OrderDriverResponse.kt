package com.example.graduation.data.models.response.order

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.DriverModel

data class OrderDriverResponse(

	@field:SerializedName("driver")
	val driverModel: DriverModel? = null
)

