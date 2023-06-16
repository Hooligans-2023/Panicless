package com.example.graduation.presentation.ui.bottomnavfragment

import com.example.graduation.data.models.postbody.CreateReadBody
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.data.models.postbody.RegisterBody

sealed class HomeEvent {

    data class CreateReading(val createReadBody: CreateReadBody) : HomeEvent()
    object  GetLastReading : HomeEvent()
    object  GetListReading : HomeEvent()
}