package com.latrics

import android.app.Application
import com.latrics.di.DependencyInjector

class MainApplication: Application() {
    val dependencyInjector by lazy {
        DependencyInjector(application = this)
    }
}