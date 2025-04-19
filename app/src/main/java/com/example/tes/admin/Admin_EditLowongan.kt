package com.example.tes.admin

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tes.R

class Admin_EditLowongan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_edit_lowongan)
        val btnbatal = findViewById<Button>(R.id.btnBatal)
        val btnsimpan = findViewById<Button>(R.id.btnSimpanPerubahan)
         btnsimpan.setOnClickListener {
             finish()
         }

        btnbatal.setOnClickListener {
            finish()
        }

    }
}