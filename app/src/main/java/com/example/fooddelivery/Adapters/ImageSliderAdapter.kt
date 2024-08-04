package com.example.fooddelivery.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fooddelivery.R

class ImageSliderAdapter(
    private val context : Context,
    private val imageList : ArrayList<Int>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    private val runnable = Runnable{
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.card_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageSliderAdapter.ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])

        if (position == imageList.size-1) {
            viewPager2.post(runnable)
        }
    }
}