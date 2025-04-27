package com.example.tes.admin.Lowongan

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class Admin_DaftarPendaftarActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_daftar_pendaftar)

        val btnbckgbr =findViewById<ImageView>(R.id.btnBackPendaftar)
        btnbckgbr.setOnClickListener {
            finish()
        }

        val rclview = findViewById<RecyclerView>(R.id.recyclerViewPendaftar)

        val lamaranlist: MutableList<Modelpendaftar> = ArrayList()
        lamaranlist.add(
            Modelpendaftar(namalengkap = "Arief Fatahillah")
        )

        rclview.layoutManager= LinearLayoutManager(this)
        val adapter= Admin_AdapterDaftarPendaftar(lamaranlist, this)
        rclview.adapter = adapter

    }

}
