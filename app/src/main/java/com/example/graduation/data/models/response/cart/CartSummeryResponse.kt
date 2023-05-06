package com.example.graduation.data.models.response.cart

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.AddressModel
import com.example.graduation.data.models.common.StoreModel

data class CartSummeryResponse(

    @field:SerializedName("payment_methods")
	val paymentMethods: List<PaymentMethodsItem?>? = null,

    @field:SerializedName("sub_total_without_conditions")
	val subTotalWithoutConditions: Double? = null,

    @field:SerializedName("total")
	val total: Double? = null,

    @field:SerializedName("addresses")
	val addresses: AddressModel? = null,

    @field:SerializedName("sup_total_with_conditions")
	val supTotalWithConditions: Double? = null,

    @field:SerializedName("total_conditions")
	val totalConditions: Double? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("total_quantity")
	val totalQuantity: Double? = null,

    @field:SerializedName("store_address")
	val storeAddress: StoreModel? = null,

    @field:SerializedName("conditions")
	val conditions: ConditionsCart? = null,

    @field:SerializedName("items")
	val items: List<ItemsCart?>? = null,

    @field:SerializedName("key")
	val key: String? = null,

    @field:SerializedName("wallet_balance")
	val walletBalance: String? = null,

    @field:SerializedName("wallet_used")
	val walletUsed: Boolean? = null,

    @field:SerializedName("cart_item_actions")
	val cartItemActionsResponse:CartItemActionsResponse? = null,

    @field:SerializedName("cart_condition_actions")
	val cartConditionActionsResponse: CartConditionActionsResponse? = null,

    @field:SerializedName("discount_amount")
	val discountAmount: Double? = null,

    @field:SerializedName("tax_amount")
	val taxAmount: Double? = null,

    @field:SerializedName("sub_total")
	val subTotal: Double? = null,

    @field:SerializedName("total_amount")
	val totalAmount: Double? = null,

    )









