package com.example.graduation.data.models.postbody

import com.google.gson.annotations.SerializedName

data class VariationsBody(

    @field:SerializedName("options")
    val options: List<Int>? = null,

)