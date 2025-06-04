package com.example.tes.admin.User

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class HasilActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tampilan_hasil)

        val tvNama = findViewById<TextView>(R.id.tvNamaPelamar)
        val tvSkor = findViewById<TextView>(R.id.tvSkor)
        val tvStatus = findViewById<TextView>(R.id.tvKeterangan)
        val btnBack = findViewById<Button>(R.id.backHasil)

        val nama = intent.getStringExtra("nama")
        val skor = intent.getStringExtra("skor")
        val status = intent.getStringExtra("status")

        if(status.equals("lulus")){
            findViewById<TextView>(R.id.tvSelamat).text = "Selamat Anda Dinyatakan Lulus Seleksi"
            findViewById<ImageView>(R.id.gambarHasil).setImageResource(R.drawable.success)
        }

        tvNama.text = nama ?: "-"
        tvSkor.text = skor ?: "-"
        tvStatus.text = status ?: "-"

        btnBack.setOnClickListener {
            finish()
        }
    }
}