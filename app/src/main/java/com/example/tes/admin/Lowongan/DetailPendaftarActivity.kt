package com.example.tes.admin.Lowongan

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tes.R

class DetailPendaftarActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_detail_pelamar)

        val pendaftar = intent.getSerializableExtra("pendaftar") as Modelpendaftar

        findViewById<TextView>(R.id.txtNamaplr).setText(pendaftar.nama)
        findViewById<TextView>(R.id.txtEmailplr).setText(pendaftar.email)
        findViewById<TextView>(R.id.txtTeleponplr).setText(pendaftar.telepon)
        findViewById<TextView>(R.id.txtPendidikanplr).setText(pendaftar.pendidikan)

        findViewById<Button>(R.id.btnKembaliplr).setOnClickListener {
            finish()
        }
    }
}
