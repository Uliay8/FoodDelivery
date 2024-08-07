package com.example.fooddelivery.Fragments

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Adapters.NotificationAdapter
import com.example.fooddelivery.Models.NotificationModel
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding
    private lateinit var notificationList: ArrayList<NotificationModel>
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)

        notificationList = ArrayList()
        notificationList.add(NotificationModel(R.drawable.n_unsuccess, "Your order has been Canceled Successfully"))
        notificationList.add(NotificationModel(R.drawable.n_deliver, "Order has been taken by the driver"))
        notificationList.add(NotificationModel(R.drawable.n_success, "Congrats Your Order Placed"))

        notificationAdapter = NotificationAdapter(requireContext(), notificationList as ArrayList<NotificationModel>)
        notificationRV = binding.notificationRV
        notificationRV.layoutManager = LinearLayoutManager(requireContext())
        notificationRV.adapter = notificationAdapter

        binding.backToMain.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

}