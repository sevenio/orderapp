package com.latrics.orderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.latrics.orderapp.MainViewModel
import com.latrics.orderapp.databinding.FragmentMainBinding
import com.latrics.orderapp.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private var binding: FragmentOrderBinding? = null

    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding?.root
    }

}