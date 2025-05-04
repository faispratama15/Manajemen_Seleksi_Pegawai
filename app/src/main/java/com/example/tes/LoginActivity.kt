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

            // Cek login admin secara lokal (tanpa API)
            if (username == "admin123" && password == "adminpass") {
                val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putInt("user_id", 0) // admin = 0
                    putString("token", "admin_token_dummy")
                    apply()
                }

                Toast.makeText(this, "Login Admin berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                return@setOnClickListener
            }

            // Login via API
            val loginRequest = LoginRequest(username, password)

            ApiClient.instance.loginUser(loginRequest)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        Log.d("LoginResponse", "Response body: ${response.body()}")
                        Log.d("LoginResponse", "Response code: ${response.code()}")

                        if (response.isSuccessful) {
                            val loginResponse = response.body()
                            Log.d("LoginDebug", "data: ${loginResponse?.data}")
                            Log.d("LoginDebug", "user id: ${loginResponse?.data?.id}")

                            if (loginResponse != null &&
                                loginResponse.status == "success" &&
                                !loginResponse.token.isNullOrEmpty()
                            ) {
                                val token = loginResponse.token
                                val userId = loginResponse.data?.id ?: -1
                                Log.d("LoginDebug", "Parsed User ID: $userId")

                                if (userId != -1) {
                                    val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)
                                    with(sharedPref.edit()) {
                                        putInt("user_id", userId)
                                        putString("token", token)
                                        apply()
                                    }
                                    Log.d("LoginDebug", "User ID berhasil disimpan: $userId")

                                    Toast.makeText(this@LoginActivity, "Login berhasil", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@LoginActivity, MainActivity2::class.java))
                                    finish()
                                } else {
                                    Toast.makeText(this@LoginActivity, "User ID tidak valid", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(this@LoginActivity, "Login gagal: ${loginResponse?.message}", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@LoginActivity, "Login gagal dengan status: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
