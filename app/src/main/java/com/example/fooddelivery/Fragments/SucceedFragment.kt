package com.example.fooddelivery.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.fooddelivery.EditingAnOrderActivity
import com.example.fooddelivery.MainActivity
import com.example.fooddelivery.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SucceedFragment : BottomSheetDialogFragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_succeed, container, false)

        val restart = view.findViewById<AppCompatButton>(R.id.back_to_home)
        restart.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}