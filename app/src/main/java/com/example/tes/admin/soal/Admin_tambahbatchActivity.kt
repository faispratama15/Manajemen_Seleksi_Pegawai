package com.example.tes.admin.soal

import TambahSoalFragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class Admin_tambahbatchActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_tambahbatch)

        val btnbuatsoal = findViewById<Button>(R.id.btnBuatSoal2)
        val btnbck = findViewById<Button>(R.id.btnSimpanBatch2)

        btnbck.setOnClickListener {
            finish()
        }

        btnbuatsoal.setOnClickListener {
            val fragment = TambahSoalFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // Biar bisa tombol back
                .commit()
        }

    }
}