package com.example.graduation.data.models.response.subscriptions

import com.google.gson.annotations.SerializedName

data class CheckSubscriptionResponse(

	@field:SerializedName("subscriptions")
	val subscriptions: List<SubscriptionsItem?>? = null
)

data class SubscriptionsItem(

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("badge_type")
	val badgeType: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("is_current")
	val isCurrent: Boolean? = null
)
