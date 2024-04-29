package com.latrics.orderapp

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.latrics.db.MenuItem


@BindingAdapter("image")
fun bindRecyclerView(imageView: ImageView,  imageId : Int) {
    Glide.with(imageView.context).load(MenuItem.drawableArray[imageId]).into(
       imageView
    )
}