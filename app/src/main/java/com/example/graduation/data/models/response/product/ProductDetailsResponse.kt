package com.example.graduation.data.models.response.product

import com.google.gson.annotations.SerializedName
import com.example.graduation.data.models.common.ProductModel

data class ProductDetailsResponse(

    @field:SerializedName("product")
    val product: ProductModel? = null
)


data class VariationsItem(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("variation_data")
    val variationData: List<VariationDataItem?>? = null,

    @field:SerializedName("variation_title")
    val variationTitle: String? = null,

    @field:SerializedName("variation_id")
    val variationId: Int? = null,

    var selectedVariationItem: Int = 0
)

data class VariationDataItem(

    @field:SerializedName("option_value_id")
    val optionValueId: String? = null,

    @field:SerializedName("option_id")
    val optionId: String? = null,

    @field:SerializedName("is_selected")
    val isSelected: Boolean? = null,

    @field:SerializedName("is_available")
    val isAvailable: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("option")
    val option: String? = null
)


data class InformationItem(

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("value")
    val value: String? = null
)

data class AdditionsItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("addition_children")
    val additionChildren: List<AdditionChildrenItem?>? = null,

    @field:SerializedName("title")
    val title: String? = null,

    var isExpanded: Boolean = false,

    )


data class AdditionChildrenItem(

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    var isSelected: Boolean = false,
)
