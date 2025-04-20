package com.example.tes.admin

import com.example.tes.ModelDaftarLowongan

data class ResponseLowongan(
    val success: Boolean,
    val message: String,
    val data: List<ModelDaftarLowongan>
)
