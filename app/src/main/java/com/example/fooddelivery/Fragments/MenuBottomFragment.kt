package com.example.fooddelivery.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Adapters.PopularFoodAdapter
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.Models.SharedModel
import com.example.fooddelivery.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomFragment : BottomSheetDialogFragment() {

    private lateinit var adapter : PopularFoodAdapter
    private lateinit var menuList : ArrayList<PopularModel>
    private lateinit var menuRv : RecyclerView
    private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_bottom, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        menuList = ArrayList()
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        menuList.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        menuList.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))

        adapter = PopularFoodAdapter(requireContext(), menuList)
        adapter.setSharedModel(sharedModel)
        menuRv = view.findViewById(R.id.all_menu_RV)
        menuRv.layoutManager = LinearLayoutManager(requireContext())
        menuRv.adapter = adapter

        return view
    }

}