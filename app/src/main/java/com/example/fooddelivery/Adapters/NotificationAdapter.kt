package com.example.fooddelivery.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Models.NotificationModel
import com.example.fooddelivery.databinding.CardFoodItemBinding
import com.example.fooddelivery.databinding.NotificationItemBinding

class NotificationAdapter (
    val context : Context,
    var notificationList : ArrayList<NotificationModel>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val itemNotification = notificationList[position]
        itemNotification.notificationImage.let { holder.notificationImage.setImageResource(it) }
        holder.notificationText.text = itemNotification.notificationText
    }

    class NotificationViewHolder(binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val notificationImage = binding.notificationImage
        val notificationText = binding.notificationName
    }
}