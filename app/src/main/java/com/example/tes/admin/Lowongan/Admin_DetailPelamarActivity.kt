
package com.example.tes.admin.Lowongan
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R


class Admin_DetailPelamarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_detail_pelamar)

        val pendaftar = intent.getSerializableExtra("pendaftar") as? Modelpendaftar

        if (pendaftar == null) {
            finish()
            return
        }
        val btnkembali = findViewById<Button>(R.id.btnKembaliplr)
        val acc = findViewById<Button>(R.id.btnAccPelamarplr)
        val btnLihatCV = findViewById<Button>(R.id.btnUploadCVplr)

        findViewById<TextView>(R.id.txtNamaplr).text = pendaftar.nama
        findViewById<TextView>(R.id.txtEmailplr).text = pendaftar.email
        findViewById<TextView>(R.id.txtTeleponplr).text = pendaftar.telepon
        findViewById<TextView>(R.id.txtPendidikanplr).text = pendaftar.pendidikan

        btnkembali.setOnClickListener {
            finish()
        }

        acc.setOnClickListener {
            finish()
        }

        btnLihatCV.setOnClickListener {
            val cvPath = pendaftar.cv
            if (!cvPath.isNullOrEmpty()) {
                val fullUrl = if (cvPath.startsWith("http")) {
                    cvPath
                } else {
                    "http://192.168.227.203:8000/storage/$cvPath" 
                }

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fullUrl))
                startActivity(intent)
            } else {
                Toast.makeText(this, "CV tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }




    }
}
