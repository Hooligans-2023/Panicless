package com.example.graduation.data.models.response.blog

import com.google.gson.annotations.SerializedName

data class BlogResponse(

	@field:SerializedName("blog")
	val blog: BlogModel? = null
)


