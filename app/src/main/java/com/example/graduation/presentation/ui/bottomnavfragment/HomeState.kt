package com.example.graduation.presentation.ui.bottomnavfragment

import com.example.graduation.data.models.response.reading.ReadingResponse

data class HomeState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val createReading: ReadingResponse? = null,
    val lastReading: List<ReadingResponse>? = null,
    val listReading: List<ReadingResponse>? = null,
    val error: String = "",

)
