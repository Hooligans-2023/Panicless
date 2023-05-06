package com.example.graduation.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(text:String, timing: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, timing).show()
    }

}