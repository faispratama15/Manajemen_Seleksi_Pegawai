package com.example.tes.admin.User


data class LoginResponse(
    val status: String,
    val message: String?,
    val token: String?,
    val data: UserData2?
)

data class UserData2(
    val id: Int,
    val nama: String,
    val nik: String,
    val username: String,
    val email: String,
    val telepon: String,
    val alamat: String,
    val jkl: String
)






