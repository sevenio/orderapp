package com.latrics.db

import androidx.room.Entity

@Entity
data class Order(
    val id: Int,
    val menuId: Int,
    val itemCount: Int
)