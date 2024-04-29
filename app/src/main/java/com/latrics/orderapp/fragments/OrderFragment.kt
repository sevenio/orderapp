package com.latrics.orderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.latrics.db.MenuItem
import com.latrics.orderapp.MainViewModel
import com.latrics.orderapp.OrderViewModel
import com.latrics.orderapp.databinding.FragmentMainBinding
import com.latrics.orderapp.databinding.FragmentOrderBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class OrderFragment : Fragment() {
    private lateinit var binding: FragmentOrderBinding
    val args: OrderFragmentArgs by navArgs()
    private lateinit var menuItem : MenuItem


    private val viewModel by viewModels<OrderViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getMenuItemById(args.itemId)
                .flowWithLifecycle(lifecycle, minActiveState = Lifecycle.State.STARTED)
                .collectLatest {
                    menuItem = it
                    binding.menuItem = it
                    binding.executePendingBindings()
                    binding.tvValue.text = "Order value is ${viewModel.count.value?.times((menuItem?.price?:0.0))}"
                }
        }
        binding.btnAdd.setOnClickListener {
            viewModel.increment()
        }
        binding.tvPlus.setOnClickListener {
            viewModel.increment()
        }
        binding.tvMinus.setOnClickListener {
            viewModel.decrement()
        }
        viewModel.count.observe(viewLifecycleOwner){
            if(it == 0){
                binding.apply {
                    btnAdd.visibility = View.VISIBLE
                    tvCount.visibility = View.GONE
                    tvPlus.visibility = View.GONE
                    tvMinus.visibility  = View.GONE
                    tvValue.visibility = View.GONE
                }
            }else {
                binding.apply {
                    btnAdd.visibility = View.GONE
                    tvCount.visibility = View.VISIBLE
                    tvPlus.visibility = View.VISIBLE
                    tvMinus.visibility  = View.VISIBLE
                    tvValue.visibility = View.VISIBLE
                    tvCount.text = it.toString()
                    tvValue.text = "Order value is ${it * (menuItem?.price?:0.0)}"
                }
            }
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnPlaceOrder.setOnClickListener {
            findNavController().navigate(OrderFragmentDirections.actionOrderFragmentToConfirmationFragment(count = viewModel.count.value?.toLong()?:0, menuId = menuItem.id))
        }

    }

}