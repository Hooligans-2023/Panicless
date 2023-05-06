package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class AddToCartBody(


    @field:SerializedName("product")
    val product: AddToCartProductBody? = null,

    @field:SerializedName("action_type")
    val actionType: String? = "add_item",

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("selected_variation_id")
    val selectedVariationId: Int? = null,

    @field:SerializedName("additions")
    val additions: List<Int>? = null,
)

data class AddToCartProductBody(

    @field:SerializedName("id")
    val id: Int? = null,

)