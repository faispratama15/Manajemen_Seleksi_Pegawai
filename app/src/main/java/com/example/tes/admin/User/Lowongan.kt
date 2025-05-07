package com.example.tes.admin.User

import com.google.gson.annotations.SerializedName

data class Lowongan(
    val id: Int,
    @SerializedName("nama")
    val posisi: String,
    val perusahaan: String
)