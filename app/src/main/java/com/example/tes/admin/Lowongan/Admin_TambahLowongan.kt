package com.example.tes.admin.Lowongan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R
import com.example.tes.admin.ApiClient
import com.example.tes.admin.HapusResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Admin_TambahLowongan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_tambah_lowongan)
        val edtNama = findViewById<EditText>(R.id.edtnama)
        val edtPerusahaan = findViewById<EditText>(R.id.edtPerusahaan)
        val edtLokasi = findViewById<EditText>(R.id.edtLokasi)
        val edtPeriode = findViewById<EditText>(R.id.edtPeriode)
        val edtDeskripsi = findViewById<EditText>(R.id.edtDeskripsi)
        val edtKualifikasi = findViewById<EditText>(R.id.edtKualifikasi)
        val btnTambah = findViewById<Button>(R.id.btnTambahLowongan)
        val btnBatal = findViewById<Button>(R.id.btnBatalbt)
        btnBatal.setOnClickListener {
            finish()
        }
        btnTambah.setOnClickListener {

        }
    }
}
