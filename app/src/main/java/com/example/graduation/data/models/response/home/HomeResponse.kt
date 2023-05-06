package com.example.graduation.data.models.response.home

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.ProductModel
import com.example.graduation.data.models.common.StoreModel

data class HomeResponse(

    @field:SerializedName("most_viewed")
	val mostViewed: List<ProductModel?>? = null,

    @field:SerializedName("nearby_stores")
	val nearbyStores: List<StoreModel?>? = null,

    @field:SerializedName("user_name")
	val userName: String? = null,

    @field:SerializedName("user_photo")
	val userPhoto: String? = null,

    @field:SerializedName("most_ordered")
	val mostOrdered: List<ProductModel?>? = null,

    @field:SerializedName("store_categories")
	val storeCategories: List<CategoryModel?>? = null,

    @field:SerializedName("sliders")
	val sliders: List<SlidersItem?>? = null,

    @field:SerializedName("new_stores")
	val newStores: List<StoreModel?>? = null
)









