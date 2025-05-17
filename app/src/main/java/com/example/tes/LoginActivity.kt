package com.example.tes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tes.admin.ApiClient
import com.example.tes.admin.MainActivity
import com.example.tes.admin.User.LoginRequest
import com.example.tes.admin.User.LoginResponse
import com.example.tes.admin.User.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_app)

        val btnDaftar = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUsername = findViewById<EditText>(R.id.editUsernamelog)
        val etPassword = findViewById<EditText>(R.id.editPasswordlog)

        btnDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Login admin lokal
            if (username == "admin123" && password == "adminpass") {
                saveUserSession(
                    userId = 0,
                    token = "admin_token_dummy",
                    nama = "Admin",
                    nik = "-",
                    telepon = "0000000000",
                    username = "admin123",
                    alamat = "Admin",
                    jkl = "Laki-laki"
                )
                Toast.makeText(this, "Login Admin berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                return@setOnClickListener
            }

            // Login API
            val loginRequest = LoginRequest(username, password)
            ApiClient.instance.loginUser(loginRequest).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    Log.d("LoginResponse", "Response: ${response.body()}")

                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        if (loginResponse != null &&
                            loginResponse.status == "success" &&
                            !loginResponse.token.isNullOrEmpty()
                        ) {
                            val user = loginResponse.data

                            // Simpan ke SharedPreferences
                            saveUserSession(
                                userId = user?.id ?: -1,
                                token = loginResponse.token,
                                nama = user?.nama ?: "",
                                nik = user?.nik ?: "",
                                telepon = user?.telepon ?: "",
                                username = user?.username ?: "",
                                alamat = user?.alamat ?: "",
                                jkl = user?.jkl ?: ""
                            )

                            Toast.makeText(this@LoginActivity, "Login berhasil", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, MainActivity2::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login gagal: ${loginResponse?.message}", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                        Log.e("LoginError", "Response not successful: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    Log.e("LoginError", "Throwable: ${t.message}")
                }
            })
        }
    }

    // ✅ Fungsi menyimpan sesi login user
    private fun saveUserSession(
        userId: Int,
        token: String?,
        nama: String?,
        nik: String?,
        telepon: String?,
        username: String?,
        alamat: String?,
        jkl: String?
    ) {
        val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        with(sharedPref.edit()) {
            putInt("user_id", userId)
            putString("token", token)
            putString("nama", nama)
            putString("nik", nik)
            putString("telepon", telepon)
            putString("username", username)
            putString("alamat", alamat)
            putString("jkl", jkl)
            apply()
        }
    }
}
