package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Adapters.PopularFoodAdapter
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.databinding.ActivityStartBinding
import com.example.fooddelivery.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: PopularFoodAdapter
    private lateinit var searchlist: ArrayList<PopularModel>
    private lateinit var searchRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        searchlist = ArrayList()
        searchlist.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_burger, "Burger", "5$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_sandwich, "Sandwich", "7$"))
        searchlist.add(PopularModel(R.drawable.pop_menu_momo, "Momo", "9$"))

        adapter = PopularFoodAdapter(requireContext(), searchlist)
        searchRV = binding.searchRV
        searchRV.layoutManager = LinearLayoutManager(requireContext())
        searchRV.adapter = adapter

        searchMenuFood()

        return binding.root
    }

    private fun searchMenuFood() {

        binding.searchItem.setOnQueryTextListener(object : OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filteredList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filteredList(newText)
                return true
            }

        })

    }

    private fun filteredList (input : String?) {
        val filteredList = if (input.isNullOrEmpty()) {
            searchlist
        } else {
            searchlist.filter { item ->
                item.getFoodName().contains(input, ignoreCase = true)
            }
        }
        adapter.updateList(filteredList as ArrayList<PopularModel>)
    }

}