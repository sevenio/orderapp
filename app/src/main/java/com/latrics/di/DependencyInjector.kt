package com.latrics.di

import com.latrics.repository.MainRepository

class DependencyInjector {
    val repository by lazy {
        MainRepository()
    }
}