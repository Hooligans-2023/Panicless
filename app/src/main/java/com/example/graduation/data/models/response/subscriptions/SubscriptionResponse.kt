package com.example.graduation.data.models.response.subscriptions

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.Paginate

data class SubscriptionResponse(

	@field:SerializedName("subscriptions")
	val subscriptions: Subscriptions
)


data class Subscriptions(

	@field:SerializedName("data")
	val data: List<SubscriptionModel>? = null,

	@field:SerializedName("paginate")
	val paginate: Paginate? = null
)

data class SubscriptionModel(

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("is_current")
	val isCurrent: Boolean? = null,

	@field:SerializedName("badge_type")
	val badgeType: String? = null
)

