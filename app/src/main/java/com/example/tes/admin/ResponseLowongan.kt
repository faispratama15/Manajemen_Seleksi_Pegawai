package com.example.tes.admin

import com.example.tes.admin.User.ModelDaftarLowongan

data class ResponseLowongan(
    val success: Boolean,
    val data: List<ModelDaftarLowongan>
)
