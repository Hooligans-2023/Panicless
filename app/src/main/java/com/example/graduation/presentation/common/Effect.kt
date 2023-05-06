package com.example.graduation.presentation.common    // Side effects
sealed class UiEffect {

    data class ShowToast(val message: String) : UiEffect()

}
