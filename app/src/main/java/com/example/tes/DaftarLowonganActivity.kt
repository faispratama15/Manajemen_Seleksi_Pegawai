package com.example.tes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarLowonganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar_lowongan)
        val rclview = findViewById<RecyclerView>(R.id.recyclerViewLowongan)

        val lowonganlist: MutableList<ModelDaftarLowongan> = ArrayList()
        lowonganlist.add(
            ModelDaftarLowongan(
                lowongan = "staff",
                Perusahaan = "PT.IKER",
                lokasi = "Antang"
            )
        )

        rclview.layoutManager=LinearLayoutManager(this)
        val adapter= AdapterDaftarLowongan(lowonganlist, this)
        rclview.adapter = adapter
    }
}