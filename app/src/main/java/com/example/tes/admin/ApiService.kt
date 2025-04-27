package com.example.tes.admin

import com.example.tes.admin.soal.SoalRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.tes.admin.soal.SoalResponse
import retrofit2.Call
import retrofit2.http.*
interface ApiService {
    @GET("lowongan/get")
    fun getLowongan(): Call<ResponseLowongan>
    @GET("lowongan/hapus")
    fun hapusLowongan(@Query("id") id: Int): Call<HapusResponse>
    @GET("lowongan/edit")
    fun editLowongan(
        @Query("id") id: Int,
        @Query("nama") nama: String,
        @Query("perusahaan") perusahaan: String,
        @Query("lokasi") lokasi: String,
        @Query("periode") periode: String,
        @Query("deskripsi") deskripsi: String,
        @Query("kualifikasi") kualifikasi: String
    ): Call<HapusResponse>
    @FormUrlEncoded
    @POST("api/lowongan/addLowongan")
    fun tambahLowongan(
        @Field("id") id: String,
        @Field("nama") nama: String,
        @Field("perusahaan") perusahaan: String,
        @Field("lokasi") lokasi: String,
        @Field("periode") periode: String,
        @Field("deskripsi") deskripsi: String,
        @Field("kualifikasi") kualifikasi: String
    ): Call<HapusResponse>

    @GET("soal")
    suspend fun getSoalByBatch(
        @Query("batch_id") batchId: Int
    ): Response<List<SoalResponse>>

    @POST("soal") // Ganti dengan endpoint yang sesuai
    suspend fun addSoal(@Body soal: SoalRequest): Response<SoalResponse>

}
