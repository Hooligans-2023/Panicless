package com.example.graduation.data.models.response.address

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.AddressModel


data class AddressesResponse(

	@field:SerializedName("user_addresss")
	val userAddress: List<AddressModel?>? = null
)
