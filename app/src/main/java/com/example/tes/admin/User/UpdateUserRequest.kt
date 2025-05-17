package com.example.tes.admin.User

data class UpdateUserRequest(
    val nama: String,
    val nik: String,
    val telepon: String,
    val username: String,
    val password: String?
)