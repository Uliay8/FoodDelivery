package com.example.fooddelivery.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Models.PopularModel
import com.example.fooddelivery.databinding.CardFoodItemBinding
import com.example.fooddelivery.databinding.FragmentCardBinding

class CardAdapter(
    val context: Context,
    var list: ArrayList<PopularModel>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardFoodItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val itemListModel = list[position]

        holder.foodName.text = itemListModel.getFoodName()
        holder.foodPrice.text = itemListModel.getFoodPrice()
        itemListModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }
        holder.foodCount.text = itemListModel.getFoodCount().toString()

        holder.plus.setOnClickListener {
            if (itemListModel.getFoodCount() < 10) {
                val count = itemListModel.getFoodCount() + 1
                itemListModel.setFoodCount(count)
                holder.foodCount.text = itemListModel.getFoodCount().toString()
            }
        }
        holder.minus.setOnClickListener {
            if (itemListModel.getFoodCount() > 1) {
                val count = itemListModel.getFoodCount() - 1
                itemListModel.setFoodCount(count)
                holder.foodCount.text = itemListModel.getFoodCount().toString()
            } else {
                holder.checkCanDeleteItem()
            }
        }
        holder.deleteBtn.setOnClickListener {
            holder.checkCanDeleteItem()
        }
    }

    inner class CardViewHolder(binding: CardFoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val foodImage = binding.cardFoodImage
        val foodName = binding.cardFoodName
        val foodPrice = binding.cardFoodPrice
        val foodCount = binding.cardFoodCount

        val plus = binding.plusBtn
        val minus = binding.minusBtn
        val deleteBtn = binding.deleteBtn

        fun checkCanDeleteItem() {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                deleteItem(adapterPosition)
            }
        }

        fun deleteItem(position: Int) {
            if (position < list.size && position >= 0) {
                list.removeAt(position)
                notifyItemRemoved(position)

            }
        }

    }
}