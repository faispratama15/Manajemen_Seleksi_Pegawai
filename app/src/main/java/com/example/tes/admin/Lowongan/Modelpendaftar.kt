package com.example.tes.admin.Lowongan


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Modelpendaftar(
    val id: Int,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("lowongan_id") val lowonganId: Int,
    val nama: String,
    val email: String,
    val telepon: String,
    val pendidikan: String,
    @SerializedName("cv") val cv: String?,
    val user: User
) : Serializable
