package com.example.tes.admin.User

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class DetailLowonganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_lowongan)
        val btndaftarsekarang = findViewById<Button>(R.id.btnLamar)
        val btnback = findViewById<Button>(R.id.btnKembali)
        val imgback = findViewById<ImageView>(R.id.back)

        imgback.setOnClickListener{
            finish()
        }

        btndaftarsekarang.setOnClickListener {
            startActivity(Intent(this, FormulirActivity::class.java))
        }
        btnback.setOnClickListener {
            finish()
        }
    }
}