package com.example.graduation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PaniclessApplication : Application(){

    override fun onCreate() {
        super.onCreate()

    }

}