package com.example.graduation.presentation.ui.auth

import com.example.graduation.data.models.postbody.RegisterBody

sealed class AuthEvent {

    data class Register(val registerBody: RegisterBody) : AuthEvent()
}