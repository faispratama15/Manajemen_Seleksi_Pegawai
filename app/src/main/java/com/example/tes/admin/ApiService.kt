
package com.example.tes.admin

import com.example.tes.admin.soal.GetBatchSoalResponse
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
    fun getBatchSoal(): Call<GetBatchSoalResponse>

    @GET("soal/batch/delete")
    fun deleteBatchSoal(@Query("id") id: Int): Call<SendResponse>



    @GET("soal")
    suspend fun getSoalByBatch(
        @Query("batch_id") batchId: Int
    ): Response<List<SoalResponse>>

    @POST("soal")
    suspend fun addSoal(@Body soal: SoalRequest): Response<SoalResponse>

}
