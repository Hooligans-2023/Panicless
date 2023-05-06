package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class SendOrderCartBody(

    @field:SerializedName("payment_id")
    val paymentId: Int? = null,
    @field:SerializedName("use_wallet")
    val useWallet: Boolean? = null,

    @field:SerializedName("scheduled")
    val scheduled: Boolean? = null,

    @field:SerializedName("address_id")
    val addressId: Int? = null,

    @field:SerializedName("schedule")
    val sendOrderCartBodyScheduleBody: SendOrderCartBodyScheduleBody? = null,

    @field:SerializedName("distance")
    val distance: Int? = null,

    @field:SerializedName("duration")
    val duration: Int? = null,

    @field:SerializedName("notes")
    val notes: String? = null,
)


data class SendOrderCartBodyScheduleBody(

    @field:SerializedName("time")
    val time: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    )