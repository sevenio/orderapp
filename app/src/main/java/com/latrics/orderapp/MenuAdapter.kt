package com.latrics.orderapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.latrics.db.MenuItem
import com.latrics.orderapp.databinding.MenuItemBinding


class MenuAdapter(val menuItemsList: MutableList<MenuItem>, val callback: (MenuItem) -> (Unit)) :
    RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder>() {

        fun setItems(itemsList: MutableList<MenuItem>){
            menuItemsList.clear()
            menuItemsList.addAll(itemsList)
            notifyDataSetChanged()
        }

    class MenuItemViewHolder(val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: MenuItem, callback: (MenuItem) -> (Unit)) {
            binding.menuItem = menuItem
            Glide
                .with(binding.root.context)
                .load(MenuItem.drawableArray[menuItem.image])
                .centerCrop()
                .into(binding.ivImage)
            binding.root.setOnClickListener {
                Log.d("ganga", "clicked")
                callback(menuItem)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(
            MenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return menuItemsList.size
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(menuItem = menuItemsList[position], callback)
    }

}