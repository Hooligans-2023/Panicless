package com.example.graduation.data.models.response.address

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.AddressModel

data class AddNewAddressResponse(

	@field:SerializedName("data")
	val address: AddressModel? = null
)


