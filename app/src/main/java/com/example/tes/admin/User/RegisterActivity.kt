package com.example.tes.admin.User

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.LoginActivity
import com.example.tes.MainActivity
import com.example.tes.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.register_calon_karyawan)
        val btnkembali = findViewById<Button>(R.id.btnKembali)
        val btndaftar = findViewById<Button>(R.id.btnDaftar)
        btnkembali.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        btndaftar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}