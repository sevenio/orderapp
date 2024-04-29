package com.latrics.repository

import android.app.Application
import com.latrics.db.MainDatabase
import com.latrics.db.MenuItem
import kotlinx.coroutines.flow.Flow

class MainRepository(val application: Application) {

    private val mainDatabase by lazy {
        MainDatabase.DatabaseManager(application).createDatabase()
    }

    val dao by lazy {
        mainDatabase.mainDao
    }

    suspend fun insertItems(list: List<MenuItem>){
        dao.insertItems(list)
    }

    fun getItemsList():Flow<List<MenuItem>>{
        return dao.getAllMenuItems()
    }
    fun getMenuItemById(id: Int):Flow<MenuItem>{
        return dao.getMenuItemById(id)
    }

}