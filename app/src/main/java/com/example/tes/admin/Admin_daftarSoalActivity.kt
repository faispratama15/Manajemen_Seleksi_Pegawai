package com.example.tes.admin

import Adapter_TambahSoal
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

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