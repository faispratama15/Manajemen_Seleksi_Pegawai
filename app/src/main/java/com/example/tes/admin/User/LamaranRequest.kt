package com.example.tes.admin.User

import okhttp3.MultipartBody

data class LamaranRequest(
    val user_id: Int,
    val lowongan_id: Int,
    val nama: String,
    val email: String,
    val telepon: String,
    val pendidikan: String,
    val status: String,
    val cv: MultipartBody.Part?
)


