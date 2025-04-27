package com.example.tes.admin.soal

import TambahSoalFragment
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R
class TambahBatchActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_tambahbatch)
        val btnBuatSoal = findViewById<Button>(R.id.btnBuatSoal2)
        val batchId = 1

        val fragment = TambahSoalFragment()
        val bundle = Bundle()
        bundle.putInt("batch_id", batchId)
        fragment.arguments = bundle
        btnBuatSoal.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TambahSoalFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
