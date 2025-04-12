package com.example.tes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuksesActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sukses)
        val btnkembali = findViewById<Button>(R.id.btnBackToHome)
        btnkembali.setOnClickListener {
            startActivity(Intent(this, DaftarLowonganActivity::class.java))
        }
    }
}