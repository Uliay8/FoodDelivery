package com.example.fooddelivery

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // тут можно с апи замутить
        val countryList = arrayOf("Russia", "Brazil", "China", "England")
        val adapter = ArrayAdapter(this@LocationActivity, android.R.layout.simple_list_item_1, countryList)

        binding.locationList.setAdapter(adapter)

        binding.locationList.setOnItemClickListener { parent, view, position, l ->
            val selectedLocation = parent.getItemAtPosition(position) as String
            showDialogAtPosition(selectedLocation)
        }
    }

    private fun showDialogAtPosition(location:String) {
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
        val dialogBuilder = AlertDialog.Builder(this@LocationActivity)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()
        dialogView.findViewById<AppCompatButton>(R.id.btn_yes).setOnClickListener {
            startActivityWithLocation(location)
            dialog.dismiss()
        }
        dialogView.findViewById<AppCompatButton>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    private fun startActivityWithLocation(location: String) {
        val intent = Intent(this@LocationActivity, MainActivity :: class.java)
        intent.putExtra("location", location)
        startActivity(intent)
        finish()
    }
}