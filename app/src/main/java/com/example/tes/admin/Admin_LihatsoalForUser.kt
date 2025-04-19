package com.example.tes.admin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class Admin_LihatsoalForUser : AppCompatActivity() {
    private val soal: MutableList<ModelTambahSoal> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.recicleview_lihatsoal)

        val recyclView = findViewById<RecyclerView>(R.id.recyclerViewSoala)
        val gbr = findViewById<ImageView>(R.id.gbrt)

        gbr.setOnClickListener {
            finish()
        }

        soal.add(
            ModelTambahSoal(pertanyaan = "Arief Fatahillah", jawabanA = "1", jawabanB = "2", jawabanC = "2", jawabanD = "5")
        )

        recyclView.layoutManager= LinearLayoutManager(this)
        val  adapter= Admin_Adapter_lihatsoalforuser(soal, this)
        recyclView.adapter = adapter

    }
}