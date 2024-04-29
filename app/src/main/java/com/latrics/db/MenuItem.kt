package com.latrics.db

import androidx.annotation.DrawableRes
import androidx.room.Entity
import kotlinx.parcelize.Parcelize


@Entity
data class MenuItem (
    val id: Int,
    val price: Double,
    val title: String,
    @DrawableRes
    val image: Int,
    val description: String
)