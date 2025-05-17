package com.example.tes.admin.User


data class RegisterRequest(
    val nik: String,
    val nama: String,
    val alamat: String,
    val jkl: String,
    val telepon: String,
    val username: String,
    val password: String
)
