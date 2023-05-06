package com.example.graduation.data.models.response.accountinfo

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.UserModel


data class AccountInfoResponse(

	@field:SerializedName("user")
	val user: UserModel? = null
)


