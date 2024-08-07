package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.Fragments.SucceedFragment
import com.example.fooddelivery.databinding.ActivityEditingAnOrderBinding

class EditingAnOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditingAnOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditingAnOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        кнопка назад, передавать и считать сумму
            // на фрагменте кард сделать переход сюда и изменить функцию + и -

        binding.backToCard.setOnClickListener {
            onBackPressed()
        }

        binding.toPlaceOrderBtn.setOnClickListener {
            val bottomFragment = SucceedFragment()
            bottomFragment.show(supportFragmentManager, "Test")
        }

        val totalCost = intent.getStringExtra("totalCost")
        val dollar = "$"
        val total = "$dollar$totalCost"
        binding.totalPrice.text = total
    }
}