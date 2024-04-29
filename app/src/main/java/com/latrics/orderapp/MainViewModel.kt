package com.latrics.orderapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.latrics.MainApplication

class MainViewModel(val application: Application): AndroidViewModel(application) {

    val repository by lazy {
        (application as MainApplication).dependencyInjector.repository
    }
}