package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Adapters.CardAdapter
import com.example.fooddelivery.Adapters.PopularFoodAdapter
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.Models.SharedModel
import com.example.fooddelivery.databinding.FragmentCardBinding

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding
//    private lateinit var list: ArrayList<PopularModel>
    private lateinit var adapter: CardAdapter
    private lateinit var cardRV: RecyclerView
    private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)
//        list = ArrayList()
//        list.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
//        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
//        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
//        list.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
//        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
//        list.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))

        adapter = CardAdapter(requireContext(), sharedModel.cardItem.value?: ArrayList())
        cardRV = binding.cardRV
        cardRV.layoutManager = LinearLayoutManager(requireContext())
        cardRV.adapter = adapter

        return binding.root
    }

}