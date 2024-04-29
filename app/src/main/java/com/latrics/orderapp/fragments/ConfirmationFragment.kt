package com.latrics.orderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.latrics.orderapp.MainViewModel
import com.latrics.orderapp.databinding.FragmentConfirmationBinding
import com.latrics.orderapp.databinding.FragmentMainBinding

class ConfirmationFragment: Fragment() {
    private var binding: FragmentConfirmationBinding? = null

    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding?.root
    }
}