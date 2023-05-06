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
    var data: T? = null

    @field:SerializedName("firstName")
    val firstName: String? = null

    @field:SerializedName("lastName")
    val lastName: String? = null

    @field:SerializedName("image")
    val image: String? = null

    @field:SerializedName("trustNumber")
    val trustNumber: String? = null

    @field:SerializedName("id")
    val id: Int? = null

    @field:SerializedName("email")
    val email: String? = null

    @Expose
    @SerializedName("info")
    val info: String? = null
}