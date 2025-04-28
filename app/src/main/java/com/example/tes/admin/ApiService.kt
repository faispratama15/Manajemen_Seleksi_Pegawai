
package com.example.tes.admin

import com.example.tes.admin.soal.GetResponeBatch
import com.example.tes.admin.soal.GetResponseSoal
import com.example.tes.admin.soal.SoalRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.tes.admin.soal.SoalResponse
import retrofit2.Call
import retrofit2.http.*
interface ApiService {
    @GET("lowongan/get")
    fun getLowongan(): Call<GetResponse>
    @GET("lowongan/delete")
    fun hapusLowongan(@Query("id") id: Int): Call<SendResponse>
    @GET("lowongan/edit")
    fun editLowongan(
        @Query("id") id: Int,
        @Query("nama") nama: String,
        @Query("perusahaan") perusahaan: String,
        @Query("lokasi") lokasi: String,
        @Query("periode") periode: String,
        @Query("deskripsi") deskripsi: String,
        @Query("kualifikasi") kualifikasi: String
    ): Call<SendResponse>

    @GET("lowongan/add")
    fun tambahLowongan(
        @Query("nama") nama: String,
        @Query("perusahaan") perusahaan: String,
        @Query("lokasi") lokasi: String,
        @Query("periode") periode: String,
        @Query("deskripsi") deskripsi: String,
        @Query("kualifikasi") kualifikasi: String
    ): Call<SendResponse>

    @GET("soal/batch/get")
    fun getBatchSoal(): Call<GetResponeBatch>

    @GET("soal/batch/add")
    fun tambahBatchSoal(
        @Query("nama") nama: String
    ): Call<SendResponse>

    @GET("soal/batch/edit")
    fun editBatchSoal(
        @Query("id") id: Int,
        @Query("nama") nama: String
    ): Call<SendResponse>

    @GET("soal/batch/delete")
    fun deleteBatchSoal(@Query("id") id: Int): Call<SendResponse>

    @GET("soal/batch/soal/get")
    fun getSoalByBatch(
        @Query("batch_soal_id") batchSoalId: Int
    ): Call<GetResponseSoal>

    @GET("soal/batch/soal/add")
    fun tambahSoal(
        @Query("batch_soal_id") batchSoalId: Int,
        @Query("soal") soal: String,
        @Query("pil1") pil1: String,
        @Query("pil2") pil2: String,
        @Query("pil3") pil3: String,
        @Query("pil4") pil4: String,
        @Query("jawaban") jawaban: String
    ): Call<SendResponse>

    @GET("soal/batch/soal/edit")
    fun editSoal(
        @Query("id") id: Int,
        @Query("soal") soal: String,
        @Query("pil1") pil1: String,
        @Query("pil2") pil2: String,
        @Query("pil3") pil3: String,
        @Query("pil4") pil4: String,
        @Query("jawaban") jawaban: String,
    ): Call<SendResponse>

    @GET("soal/batch/soal/delete")
    fun hapusSoal(
        @Query("id") id: Int
    ): Call<SendResponse>

}
