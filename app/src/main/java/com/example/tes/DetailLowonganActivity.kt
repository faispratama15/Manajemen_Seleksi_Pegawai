package com.example.tes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailLowonganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_lowongan)
        val btndaftarsekarang = findViewById<Button>(R.id.btnLamar)
        val btnback = findViewById<Button>(R.id.btnKembali)
        btndaftarsekarang.setOnClickListener {
            startActivity(Intent(this, FormulirActivity::class.java))
        }
        btnback.setOnClickListener {
            startActivity(Intent(this, AdapterDaftarLowongan::class.java ))
        }
    }
}