package com.example.tes.admin.soal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.ModelTambahSoal

class Admin_daftarSoalActivity : AppCompatActivity() {

    private val soal: MutableList<ModelTambahSoal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.admin_daftarsoal)

        val recyclView = findViewById<RecyclerView>(R.id.recyclerViewsoalditambah)

        soal.add(
            ModelTambahSoal(pertanyaan = "Arief Fatahillah", jawabanA = "1", jawabanB = "2", jawabanC = "2", jawabanD = "5")
        )

        recyclView.layoutManager= LinearLayoutManager(this)
        val  adapter= Adapter_TambahSoal(soal, this)
        recyclView.adapter = adapter

    }

}