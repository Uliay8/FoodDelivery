package com.example.fooddelivery.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.DetailsActivity
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.databinding.HomeFoodItemBinding

class PopularFoodAdapter(
    val context: Context,
    var list: ArrayList<PopularModel>
) : RecyclerView.Adapter<PopularFoodAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = HomeFoodItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

        val itemListModel = list[position]

        holder.foodName.text = itemListModel.getFoodName()
        holder.foodPrice.text = itemListModel.getFoodPrice()
        itemListModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }

        holder.item.setOnClickListener {
            val intent = Intent(context, DetailsActivity :: class.java)
            intent.putExtra("foodImage", itemListModel.getFoodImage())
            intent.putExtra("foodName", itemListModel.getFoodName())
            context.startActivity(intent)
        }

    }

    class PopularViewHolder(binding: HomeFoodItemBinding ) : RecyclerView.ViewHolder(binding.root){

        val foodImage = binding.homeFoodImage
        val foodName = binding.homeFoodName
        val foodPrice = binding.homeFoodPrice

        val item = binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList:ArrayList<PopularModel>){
        list = newList
        notifyDataSetChanged()
    }
}