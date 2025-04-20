package com.example.tes.admin
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("lowongan/get")
    fun getLowongan(): Call<ResponseLowongan>

    @GET("lowongan/hapus")
    fun hapusLowongan(@retrofit2.http.Query("id") id: Int): Call<HapusResponse>

    @GET("lowongan/edit")
    fun editLowongan(
        @retrofit2.http.Query("id") id: Int,
        @retrofit2.http.Query("nama") nama: String,
        @retrofit2.http.Query("perusahaan") perusahaan: String,
        @retrofit2.http.Query("lokasi") lokasi: String,
        @retrofit2.http.Query("periode") periode: String,
        @retrofit2.http.Query("deskripsi") deskripsi: String,
        @retrofit2.http.Query("kualifikasi") kualifikasi: String
    ): Call<HapusResponse> // Kamu bisa buat model terpisah jika mau

}
