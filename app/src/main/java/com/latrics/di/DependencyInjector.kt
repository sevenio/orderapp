package com.latrics.di

import android.app.Application
import com.latrics.repository.MainRepository

class DependencyInjector(application: Application) {
    val repository by lazy {
        MainRepository(application)
    }
}