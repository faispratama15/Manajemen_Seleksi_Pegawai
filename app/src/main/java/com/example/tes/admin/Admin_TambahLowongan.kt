package com.example.tes.admin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R
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
        btnBatal.setOnClickListener { finish() }
        btnTambah.setOnClickListener {
            val nama = edtNama.text.toString()
            val perusahaan = edtPerusahaan.text.toString()
            val lokasi = edtLokasi.text.toString()
            val periode = edtPeriode.text.toString()
            val deskripsi = edtDeskripsi.text.toString()
            val kualifikasi = edtKualifikasi.text.toString()

            if (nama.isEmpty() || perusahaan.isEmpty() || lokasi.isEmpty() || periode.isEmpty() || deskripsi.isEmpty() || kualifikasi.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            ApiClient.instance.tambahLowongan(nama, perusahaan, lokasi, periode, deskripsi, kualifikasi)
                .enqueue(object : Callback<HapusResponse> {
                    override fun onResponse(call: Call<HapusResponse>, response: Response<HapusResponse>) {
                        Log.d("API_Response", "Code: ${response.code()}")
                        Log.d("API_Response", "Body: ${response.body()}")
                        if (response.isSuccessful && response.body()?.success == true) {
                            Toast.makeText(this@Admin_TambahLowongan, "Berhasil menambahkan lowongan", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this@Admin_TambahLowongan, "Gagal menambahkan", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<HapusResponse>, t: Throwable) {
                        Toast.makeText(this@Admin_TambahLowongan, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
