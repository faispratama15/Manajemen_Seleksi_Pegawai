package com.example.tes.admin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.AdapterDaftarLowongan
import com.example.tes.ModelDaftarLowongan
import com.example.tes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
