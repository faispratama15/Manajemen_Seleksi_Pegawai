package com.example.tes.admin.soal

import com.example.tes.admin.ModelBatch

data class GetBatchSoalResponse(
    val success: Boolean,
    val message: String,
    val data: List<ModelBatch>
)