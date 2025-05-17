package com.example.tes.admin.User

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.R
import com.example.tes.admin.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfilActivity : AppCompatActivity() {

    private lateinit var edtNama: EditText
    private lateinit var edtNik: EditText
    private lateinit var edtTelepon: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtAlamat: EditText
    private lateinit var radioGroupJkl: RadioGroup
    private lateinit var btnSimpan: Button
    private lateinit var btnKembali: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)
        val userId = sharedPref.getInt("user_id", 0)

        edtNama = findViewById(R.id.edtNamaProfile)
        edtNik = findViewById(R.id.edtNik)
        edtTelepon = findViewById(R.id.edtTeleponprofile)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.editPassword)
        edtAlamat = findViewById(R.id.edtAlamat)
        radioGroupJkl = findViewById(R.id.radioGroupJkl)
        btnSimpan = findViewById(R.id.btnSimpanprofile)
        btnKembali = findViewById(R.id.backprofile)

        // Tampilkan data terakhir dari SharedPreferences
        edtNama.setText(sharedPref.getString("nama", ""))
        edtNik.setText(sharedPref.getString("nik", ""))
        edtTelepon.setText(sharedPref.getString("telepon", ""))
        edtUsername.setText(sharedPref.getString("username", ""))
        edtAlamat.setText(sharedPref.getString("alamat", ""))

        val jkl = sharedPref.getString("jkl", "")
        if (jkl == "L" || jkl == "Laki-laki") {
            radioGroupJkl.check(R.id.radioLaki)
        } else if (jkl == "P" || jkl == "Perempuan") {
            radioGroupJkl.check(R.id.radioPerempuan)
        }

        btnSimpan.setOnClickListener {
            val nama = edtNama.text.toString()
            val nik = edtNik.text.toString()
            val telepon = edtTelepon.text.toString()
            val username = edtUsername.text.toString()
            val password = edtPassword.text?.toString()?.takeIf { it.isNotBlank() } ?: ""
            val alamat = edtAlamat.text.toString()

            val selectedJklId = radioGroupJkl.checkedRadioButtonId
            val jklText = findViewById<RadioButton>(selectedJklId)?.text.toString()
            val jklValue = when (jklText) {
                "Laki-laki" -> "L"
                "Perempuan" -> "P"
                else -> ""
            }

            if (nama.isEmpty() || nik.isEmpty() || telepon.isEmpty() || username.isEmpty() || alamat.isEmpty() || jklValue.isEmpty()) {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
            } else {
                updateProfile(sharedPref, userId, nama, nik, telepon, username, password, alamat, jklValue)
            }
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }

    private fun updateProfile(
        sharedPref: android.content.SharedPreferences,
        id: Int,
        nama: String,
        nik: String,
        telepon: String,
        username: String,
        password: String,
        alamat: String,
        jkl: String
    ) {
        val token = sharedPref.getString("token", "") ?: ""

        val api = ApiClient.instance
        val data = mutableMapOf(
            "nama" to nama,
            "nik" to nik,
            "telepon" to telepon,
            "username" to username,
            "alamat" to alamat,
            "jkl" to jkl
        )

        if (password.isNotEmpty()) {
            data["password"] = password
        }

        val call = api.updateUser("Bearer $token", id, data)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Simpan data yang telah diperbarui ke SharedPreferences
                    val editor = sharedPref.edit()
                    editor.putString("nama", nama)
                    editor.putString("nik", nik)
                    editor.putString("telepon", telepon)
                    editor.putString("username", username)
                    editor.putString("alamat", alamat)
                    editor.putString("jkl", jkl)
                    editor.apply()

                    Toast.makeText(this@EditProfilActivity, "Profil berhasil diperbarui", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val errorMsg = response.errorBody()?.string()
                    Log.e("API Error", errorMsg ?: "Tidak ada detail kesalahan")
                    Toast.makeText(this@EditProfilActivity, "Gagal update: $errorMsg", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@EditProfilActivity, "Gagal terhubung: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
