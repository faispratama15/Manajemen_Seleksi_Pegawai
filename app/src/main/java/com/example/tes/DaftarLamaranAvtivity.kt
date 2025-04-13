package com.example.tes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class DaftarLamaranAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lamaran_saya)
        val rclview = findViewById<RecyclerView>(R.id.recyclerLamaran)

        val lowonganlist: MutableList<ModelDaftarLamaran> = ArrayList()
        lowonganlist.add(
            ModelDaftarLamaran(
                posisi = "staff",
                Perusahaan = "PT.IKER",
                status = "Selamat anda lulus"
            )
        )
    }
}