package com.example.tes.admin.User

data class ModelDaftarLamaran(
    val id: Int,
    val user_id: Int,
    val lowongan_id: Int,
    val status: String,
    val lowongan: Lowongan
)


