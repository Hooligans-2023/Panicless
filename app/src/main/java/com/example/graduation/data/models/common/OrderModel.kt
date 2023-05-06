package com.example.graduation.data.models.common

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.response.order.Addresses

data class OrderModel(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("rate")
    val rate: Double? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("store")
    val store: StoreModel? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("payment_method")
    val paymentMethod: String? = null,

    @field:SerializedName("payment_method_id")
    val paymentMethodId: Int? = null,


    @field:SerializedName("addresses")
    val addresses: Addresses? = null,

    @field:SerializedName("total")
    val total: Double? = null,

    @field:SerializedName("delivery_cost")
    val deliveryCost: Int? = null,

    @field:SerializedName("driver")
    val driver: DriverModel? = null,

    @field:SerializedName("sub_total")
    val subTotal: Double? = null,

    @field:SerializedName("has_offers")
    val hasOffers: Boolean? = null,

    @field:SerializedName("products")
    val products: List<ProductModel?>? = null,

    @field:SerializedName("reasons")
    val rejectReason: List<RejectReason?>? = null

)
