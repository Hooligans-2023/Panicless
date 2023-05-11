package com.example.graduation.presentation.ui.auth

import android.net.Uri
import com.example.graduation.data.models.response.auth.LoginResponse
import com.example.graduation.data.models.response.auth.RegisterResponse

data class AuthState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val registerResponse: RegisterResponse? = null,
    val loginResponse: LoginResponse? = null,
    val error: String = "",
    val name: String = "",
    val nameError: Int? = null,
    val email: String = "",
    val emailError: Int? = null,
    val password: String = "",
    val passwordError: Int? = null,
    val passwordIsVisible: Boolean = false,
    val passwordConfirmation: String = "",
    val passwordConfirmationError: Int? = null,
    val passwordConfirmationIsVisible: Boolean = false,
    val phone: String = "",
    val phoneError: Int? = null,
    val gender: String = "male",
    val birthDate: String = "",
    val birthDateError: Int? = null,
    val termsAndConditions: Boolean = false,
    val termsAndConditionsError: Int? = null,
    val avatar: String? = null,
    val imageUri: Uri? = null,
)
