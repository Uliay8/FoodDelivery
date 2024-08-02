package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivitySingUpUserBinding

class SingUpUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySingUpUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySingUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.goUserLoginUpBtn.setOnClickListener {
            val intent = Intent(this@SingUpUserActivity, LoginUserActivity :: class.java)
            startActivity(intent)
            finish()
        }
        binding.createAccountBtn.setOnClickListener {
            // создание аккаунта тут должно быть
            val intent = Intent(this@SingUpUserActivity, LocationActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}