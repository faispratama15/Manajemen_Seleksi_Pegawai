package com.example.tes.admin.soal

data class SoalResponse(
    val id: Int,
    val batch_id: Int?,
    val pertanyaan: String,
    val jawaban_a: String,
    val jawaban_b: String,
    val jawaban_c: String,
    val jawaban_d: String,
    val jawaban_benar: String,
    val created_at: String?,
    val updated_at: String?
)
