package com.example.tes.admin.User

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R

class EditProfilActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        val back = findViewById<Button>(R.id.backprofile)
                back.setOnClickListener {
                    finish()
                }

    }
}