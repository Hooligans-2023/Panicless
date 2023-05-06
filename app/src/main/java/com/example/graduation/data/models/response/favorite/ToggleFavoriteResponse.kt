package com.example.graduation.data.models.response.favorite

import com.google.gson.annotations.SerializedName



data class ToggleFavoriteResponse(

	@field:SerializedName("user_favorites")
	val userFavorites: List<FavoriteProduct?>? = null
)

