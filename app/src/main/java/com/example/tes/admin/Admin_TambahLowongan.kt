package com.example.tes.admin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tes.R

class Admin_TambahLowongan : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_tambah_lowongan)
        val btntambah = findViewById<Button>(R.id.btnTambahLowongan)
        val btnbatal = findViewById<Button>(R.id.btnBatalbt)

        btnbatal.setOnClickListener {
            finish()
             }
        btntambah.setOnClickListener {
            finish()
        }
    }
}