package com.example.graduation.data.models.response.favorite

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate


data class FavoritesResponse(

	@field:SerializedName("user_favorites")
	val userFavorites: UserFavorites? = null
)


data class UserFavorites(

	@field:SerializedName("data")
	val data: List<FavoriteProduct>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)

