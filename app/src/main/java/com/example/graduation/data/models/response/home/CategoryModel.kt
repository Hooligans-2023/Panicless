package com.example.graduation.data.models.response.home

import com.google.gson.annotations.SerializedName

data class CategoryModel(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)