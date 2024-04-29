package com.latrics.db

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latrics.orderapp.R
import kotlinx.parcelize.Parcelize


@Entity
data class MenuItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val price: Double,
    val title: String,
    val image: Int,
    val description: String
) {
    companion object {
        val drawableArray = arrayOf(
            R.drawable.coffee_crema,
            R.drawable.fried_egg_avocado_open_sandwich,
            R.drawable.fruit_tarts,
            R.drawable.strawberry_milk_splash,
            R.drawable.mediterranean_chickpea_salad,
            R.drawable.seafood_soup,
            R.drawable.pouring_honey_on_pancakes,
            R.drawable.pink_macarons,
            R.drawable.plate_of_noodles_with_shrimps,
            R.drawable.juicy_cheeseburger
        )
    }
}

