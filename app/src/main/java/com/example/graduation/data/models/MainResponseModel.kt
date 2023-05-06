package com.example.graduation.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("UNCHECKED_CAST")
class MainResponseModel<T> {
    @Expose
    @SerializedName("code")
    val code: Int? = null
    @Expose
    @SerializedName("message")
    val message: String? = null

    @SerializedName("status")
    val status: Boolean? = null

    @SerializedName("body")
    var data:T? = null

    @Expose
    @SerializedName("info")
    val info: String? = null
}