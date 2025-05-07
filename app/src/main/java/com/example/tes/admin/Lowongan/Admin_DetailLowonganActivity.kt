package com.example.tes.admin.Lowongan

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class Admin_DetailLowonganActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_detail_lowongan)

        val Nama = findViewById<TextView>(R.id.nama)
        val Perusahaan = findViewById<TextView>(R.id.perusahaan)
        val Lokasi = findViewById<TextView>(R.id.lokasi)
        val Periode = findViewById<TextView>(R.id.periode)
        val Deskripsi = findViewById<TextView>(R.id.deskripsi)
        val Kualifikasi = findViewById<TextView>(R.id.kualifikasi)
        val btnlihatpendaftar = findViewById<Button>(R.id.btnLihatPendaftarForAdmin)
        val btnmulaiseleksi = findViewById<Button>(R.id.btnMulaiSeleksiforAdmin)
        val btnkembali = findViewById<Button>(R.id.btnbackDaftarLowonganForAdmin)
        val btngambarbck = findViewById<ImageView>(R.id.bckbck)

        Nama.setText(intent.getStringExtra("nama"))
        Perusahaan.setText(intent.getStringExtra("perusahaan"))
        Lokasi.setText(intent.getStringExtra("lokasi"))
        Periode.setText(intent.getStringExtra("periode"))
        Deskripsi.setText(intent.getStringExtra("deskripsi"))
        Kualifikasi.setText(intent.getStringExtra("kualifikasi"))

        val lowonganId = intent.getIntExtra("lowongan_id", -1)


        btnlihatpendaftar.setOnClickListener {
            val intent = Intent(this, Admin_DaftarPendaftarActivity::class.java)
            intent.putExtra("lowongan_id", lowonganId)
            Log.d("DetailLowongan", "Kirim lowongan_id: $lowonganId")
            startActivity(intent)
        }



        btnkembali.setOnClickListener {
            finish()
        }
        btngambarbck.setOnClickListener {
            finish()
        }

    }
}