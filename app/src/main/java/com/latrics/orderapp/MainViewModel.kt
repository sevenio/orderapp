package com.latrics.orderapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.latrics.MainApplication
import com.latrics.db.MenuItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val application: Application): AndroidViewModel(application) {

    val repository by lazy {
        (application as MainApplication).dependencyInjector.repository
    }

    fun insertItems(list: List<MenuItem>){
        viewModelScope.launch {
            repository.insertItems(list)
        }
    }
    fun getItemsList():Flow<List<MenuItem>>{
        return repository.getItemsList()
    }


}