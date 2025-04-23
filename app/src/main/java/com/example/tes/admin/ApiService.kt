package com.example.tes.admin
import com.example.tes.ModelDaftarLowongan
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


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
    ): Call<HapusResponse>


    @FormUrlEncoded
    @POST("api/lowongan/addLowongan")
    fun tambahLowongan(
        @Field("nama") nama: String,
        @Field("perusahaan") perusahaan: String,
        @Field("lokasi") lokasi: String,
        @Field("periode") periode: String,
        @Field("deskripsi") deskripsi: String,
        @Field("kualifikasi") kualifikasi: String
    ): Call<HapusResponse>



}
