package com.example.tes.admin

import Adapter_daftarSoalForuser
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class SoalDariadminforuser : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var soalAdapter: Adapter_daftarSoalForuser
    private var soalList: MutableList<ModelBatch> = ArrayList()
    private lateinit var btnBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recicleview_daftarsoaldikirimkepelamar)

        recyclerView = findViewById(R.id.recyclerViewSoal)
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnBack = findViewById(R.id.backInRecicleViewLihatSoal)
        btnBack.setOnClickListener {
            finish()
        }

        soalList.add(
            ModelBatch(namaBatch = "sgdgrhh")
        )

        soalAdapter = Adapter_daftarSoalForuser(soalList, this)
        recyclerView.adapter = soalAdapter
    }
}
