package com.tinikling.com.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tinikling.com.ViewModelSignUp

class SignUpModelFactory (private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelSignUp::class.java)) {
            return ViewModelSignUp(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
