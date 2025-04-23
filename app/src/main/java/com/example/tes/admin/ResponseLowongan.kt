package com.example.tes.admin

import com.example.tes.ModelDaftarLowongan

data class ResponseLowongan(
    val success: Boolean,
    val data: List<ModelDaftarLowongan>
)
