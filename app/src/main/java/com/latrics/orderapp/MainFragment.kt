package com.latrics.orderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.latrics.db.MenuItem
import com.latrics.orderapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding?.rvMenu?.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = MenuAdapter(getMenuItemList()){

               findNavController().navigate(MainFragmentDirections.actionMainFragmentToOrderFragment())
            }
        }
    }

    fun getMenuItemList(): List<MenuItem> {
        return listOf(
            MenuItem(
                id = 1,
                price = 30.0,
                title = "Coffee",
                image = R.drawable.coffee_crema,
                description = "Coffee crema"
            ),
            MenuItem(
                id = 2,
                price = 40.0,
                title = "Sandwich",
                image = R.drawable.fried_egg_avocado_open_sandwich,
                description = "Fried egg avacado open sandwich"
            ),
            MenuItem(
                id = 3,
                price = 50.0,
                title = "Fruit tarts",
                image = R.drawable.fruit_tarts,
                description = "Fruit tarts"
            ),
            MenuItem(
                id = 4,
                price = 60.0,
                title = "Strawberry Milkshake",
                image = R.drawable.strawberry_milk_splash,
                description = "Strawberry milkshake"
            ),
            MenuItem(
                id = 5,
                price = 70.0,
                title = "Salad",
                image = R.drawable.mediterranean_chickpea_salad,
                description = "Mediterranean Chickpea Salad"
            ),
            MenuItem(
                id = 6,
                price = 80.0,
                title = "Seafood Soup",
                image = R.drawable.seafood_soup,
                description = "Soup of seafood"
            ),
            MenuItem(
                id = 7,
                price = 90.0,
                title = "Honey Pancakes",
                image = R.drawable.pouring_honey_on_pancakes,
                description = "Pancakes with honey"
            ),
            MenuItem(
                id = 8,
                price = 100.0,
                title = "Pink Macrons",
                image = R.drawable.pink_macarons,
                description = "Pink macrons"
            ),
            MenuItem(
                id = 9,
                price = 110.0,
                title = "Shrimp Noodles",
                image = R.drawable.plate_of_noodles_with_shrimps,
                description = "Plate of noodles with shrimps"
            ),
            MenuItem(
                id = 10,
                price = 120.0,
                title = "Juicy Cheeseburger",
                image = R.drawable.juicy_cheeseburger,
                description = "Juicy Cheeseburger"
            ),
        )
    }
}