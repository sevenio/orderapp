package com.latrics.orderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.latrics.db.MenuItem
import com.latrics.orderapp.MainFragmentDirections
import com.latrics.orderapp.MainViewModel
import com.latrics.orderapp.MenuAdapter
import com.latrics.orderapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val viewModel by activityViewModels<MainViewModel>()

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
                image = 0,
                description = "Coffee crema"
            ),
            MenuItem(
                id = 2,
                price = 40.0,
                title = "Sandwich",
                image = 1,
                description = "Fried egg avacado open sandwich"
            ),
            MenuItem(
                id = 3,
                price = 50.0,
                title = "Fruit tarts",
                image = 2,
                description = "Fruit tarts"
            ),
            MenuItem(
                id = 4,
                price = 60.0,
                title = "Strawberry Milkshake",
                image = 3,
                description = "Strawberry milkshake"
            ),
            MenuItem(
                id = 5,
                price = 70.0,
                title = "Salad",
                image = 4,
                description = "Mediterranean Chickpea Salad"
            ),
            MenuItem(
                id = 6,
                price = 80.0,
                title = "Seafood Soup",
                image = 5,
                description = "Soup of seafood"
            ),
            MenuItem(
                id = 7,
                price = 90.0,
                title = "Honey Pancakes",
                image = 6,
                description = "Pancakes with honey"
            ),
            MenuItem(
                id = 8,
                price = 100.0,
                title = "Pink Macrons",
                image = 7,
                description = "Pink macrons"
            ),
            MenuItem(
                id = 9,
                price = 110.0,
                title = "Shrimp Noodles",
                image = 8,
                description = "Plate of noodles with shrimps"
            ),
            MenuItem(
                id = 10,
                price = 120.0,
                title = "Juicy Cheeseburger",
                image = 9,
                description = "Juicy Cheeseburger"
            ),
        )
    }
}