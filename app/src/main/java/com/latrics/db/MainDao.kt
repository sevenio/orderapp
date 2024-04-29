package com.latrics.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {

    @Upsert
    suspend fun insertItems(list: List<MenuItem>)

    @Query("Select * from MenuItem")
    fun getAllMenuItems(): Flow<List<MenuItem>>

    @Query("Select * from MenuItem where id = :id")
    fun getMenuItemById(id: Int): Flow<MenuItem>
}