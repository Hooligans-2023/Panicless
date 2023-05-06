package com.example.graduation.data.models.response.order

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.RejectReason

data class RejectReasonsResponse(

    @field:SerializedName("reasons")
    val reasons: Reasons? = null
)

data class Reasons(

    @field:SerializedName("data")
    val data: List<RejectReason?>? = null,
)


