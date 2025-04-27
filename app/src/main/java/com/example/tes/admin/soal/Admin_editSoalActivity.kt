package com.example.tes.admin.soal


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class Admin_editSoalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_edit_soal)
        val btn = findViewById<Button>(R.id.btnSimpanSoal)
        btn.setOnClickListener {
            finish()
        }

    }
}