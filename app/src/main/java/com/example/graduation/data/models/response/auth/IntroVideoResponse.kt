package com.example.graduation.data.models.response.auth

import com.google.gson.annotations.SerializedName

data class IntroVideoResponse(

    @field:SerializedName("video")
    val video: Video? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class Video(

    @field:SerializedName("url")
    val url: String? = null
)


