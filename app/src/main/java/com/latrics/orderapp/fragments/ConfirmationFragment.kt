package com.latrics.orderapp.fragments

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.latrics.db.MenuItem
import com.latrics.orderapp.ConfirmationViewmodel
import com.latrics.orderapp.MainViewModel
import com.latrics.orderapp.R
import com.latrics.orderapp.databinding.FragmentConfirmationBinding
import com.latrics.orderapp.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ConfirmationFragment: Fragment() {
    private lateinit var binding: FragmentConfirmationBinding
    val args: ConfirmationFragmentArgs by navArgs()
    private lateinit var menuItem : MenuItem

    private val viewModel by activityViewModels<ConfirmationViewmodel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getMenuItemById(args.menuId)
                .flowWithLifecycle(lifecycle, minActiveState = Lifecycle.State.STARTED)
                .collectLatest {
                    menuItem = it
                    binding.menuItem = it
                    binding.executePendingBindings()
                    binding.tvValue.text = "Order value is ${args.count * (menuItem?.price?:0.0)}"

                }
        }
        binding.btnPlaceOrder.setOnClickListener {
            Toast.makeText(requireContext(), "Order successfull placed", Toast.LENGTH_LONG).show()
            findNavController().popBackStack(R.id.mainFragment, false)
        }
    }
}