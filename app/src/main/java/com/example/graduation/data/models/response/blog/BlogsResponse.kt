package com.example.graduation.data.models.response.blog

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate


data class BlogsResponse(

	@field:SerializedName("blogs")
	val blogs: Blogs? = null
)



data class Blogs(

	@field:SerializedName("data")
	val data: List<BlogModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)


