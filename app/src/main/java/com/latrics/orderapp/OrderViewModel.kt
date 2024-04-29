package com.latrics.orderapp

import android.app.Application
import android.util.MutableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latrics.MainApplication
import com.latrics.db.MenuItem
import kotlinx.coroutines.flow.Flow

class OrderViewModel(application: Application) : AndroidViewModel(application) {
    val repository by lazy {
        (application as MainApplication).dependencyInjector.repository
    }
    val _count = MutableLiveData<Int>(0)
    val count : LiveData<Int> = _count
    fun getMenuItemById(id: Int): Flow<MenuItem> {
        return repository.getMenuItemById(id)
    }

    fun increment(){
        _count.postValue(_count.value?.plus(1))
    }
    fun decrement(){
        if((_count.value ?: 0) > 0) {
            _count.postValue(_count.value?.minus(1))
        }
    }
}