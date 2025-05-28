package com.example.colorsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.colorsapp.databinding.FragmentGreenBinding


class GreenFragment : Fragment() {
    private lateinit var binding: FragmentGreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGreenBinding.inflate(inflater, container, false)
        binding.root.setOnClickListener {
            Toast.makeText(context, "Is clicked!", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}