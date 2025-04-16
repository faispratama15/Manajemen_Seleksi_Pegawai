package com.example.tes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormulirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mendaftar_lowongan)
        val btnkembali = findViewById<Button>(R.id.btnKembali3)
        val btnkirim = findViewById<Button>(R.id.btnKirim)
        btnkembali.setOnClickListener {
           finish()
        }
        btnkirim.setOnClickListener {
            startActivity(Intent(this, SuksesActiviy::class.java))
        }
    }
}