package com.example.sildesmission

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sildesmission.databinding.FragmentPage4Binding

class Page4Fragment : Fragment() {
    lateinit var binding: FragmentPage4Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPage4Binding.inflate(inflater,container,false)
        binding.back.setOnClickListener {
            startActivity(Intent(context,MainActivity::class.java))
        }
        return binding.root
    }


}