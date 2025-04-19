package com.example.tes.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class Admin_DetailLowonganActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_detail_lowongan)

        val btnlihatpendaftar = findViewById<Button>(R.id.btnLihatPendaftarForAdmin)
        val btnmulaiseleksi = findViewById<Button>(R.id.btnMulaiSeleksiforAdmin)
        val btnkembali = findViewById<Button>(R.id.btnbackDaftarLowonganForAdmin)
        val btngambarbck = findViewById<ImageView>(R.id.bckbck)

        btnlihatpendaftar.setOnClickListener {
            startActivity(Intent(this,Admin_DaftarPendaftarActivity::class.java))
        }

        btnmulaiseleksi.setOnClickListener {
            startActivity(Intent(this,SoalDariadminforuser::class.java))
        }

        btnkembali.setOnClickListener {
            finish()
        }
        btngambarbck.setOnClickListener {
            finish()
        }

    }
}