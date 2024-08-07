package com.example.fooddelivery.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Adapters.CardAdapter
import com.example.fooddelivery.EditingAnOrderActivity
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.Models.SharedModel
import com.example.fooddelivery.databinding.FragmentCardBinding

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding
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

        adapter = CardAdapter(requireContext(), sharedModel.cardItem.value ?: ArrayList())
        cardRV = binding.cardRV
        cardRV.layoutManager = LinearLayoutManager(requireContext())
        cardRV.adapter = adapter

        binding.proceedBtn.setOnClickListener {
            val totalCost = sharedModel.cardItem.value?.let { it1 -> calculateCost(it1) }
            if (totalCost == 0) {
                Toast.makeText(requireContext(), "List is empty!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(requireContext(), EditingAnOrderActivity::class.java)
                intent.putExtra("totalCost", totalCost.toString())
                startActivity(intent)
            }
        }

        return binding.root
    }

    fun calculateCost (itemPrices : List<PopularModel>) : Int {
        var totalCost = 0

        itemPrices.forEach{ itemPrice ->
            var itemCost = itemPrice.getFoodCount() * itemPrice.getOnlyPrice()
            totalCost += itemCost
        }

        return totalCost
    }

}