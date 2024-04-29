package com.latrics.orderapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.latrics.MainApplication
import com.latrics.db.MenuItem
import kotlinx.coroutines.flow.Flow

class ConfirmationViewmodel(application: Application): AndroidViewModel(application) {
    val repository by lazy {
        (application as MainApplication).dependencyInjector.repository
    }
    fun getMenuItemById(id: Int): Flow<MenuItem> {
        return repository.getMenuItemById(id)
    }
}