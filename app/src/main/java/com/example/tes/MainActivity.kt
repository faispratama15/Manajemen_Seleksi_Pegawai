package com.example.tes

import ViewPagerAdapter
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val daftar: LinearLayout = findViewById(R.id.daftar)
        val daftarlamaran: LinearLayout = findViewById(R.id.lamaransaya)
        val profil: LinearLayout = findViewById(R.id.profil)
        val viewpager = findViewById<ViewPager2>(R.id.viewpager)

        viewpager.adapter = ViewPagerAdapter(this)
        daftar.setOnClickListener{
           viewpager.currentItem=0
        }
        daftarlamaran.setOnClickListener{
                viewpager.currentItem=1
        }
        profil.setOnClickListener{
            viewpager.currentItem=2
        }


    }
}