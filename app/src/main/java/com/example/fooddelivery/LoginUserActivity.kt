package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivityLoginUserBinding

class LoginUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.goUserSingUpBtn.setOnClickListener {
            val intent = Intent(this@LoginUserActivity, SingUpUserActivity :: class.java)
            startActivity(intent)
            finish()
        }
        binding.loginBtn.setOnClickListener {
            // проверка аккаунта должна быть
            val intent = Intent(this@LoginUserActivity, MainActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}