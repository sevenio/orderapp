package com.latrics.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.latrics.orderapp.BuildConfig


@Database(
    entities = [
        MenuItem::class,
        Order::class,

    ], version = 1, exportSchema = true
)
abstract class MainDatabase : RoomDatabase() {

    abstract val mainDao: MainDao


    companion object {
        private val DATABASE_NAME = "com_tvisha_QuadgenAt"
    }

    class DatabaseManager(val context: Context) {


        fun createDatabase() = if (BuildConfig.DEBUG) {
            Room.databaseBuilder(context, MainDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        } else {
            Room.databaseBuilder(context, MainDatabase::class.java, DATABASE_NAME)
                .build()
        }

    }
}