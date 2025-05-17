
package com.example.tes.admin

import LamaranResponse
import com.example.tes.admin.Lowongan.GetPendaftarResponse
import com.example.tes.admin.User.CekLamaranResponse
import com.example.tes.admin.User.ModelDaftarLamaran
import com.example.tes.admin.User.LoginRequest
import com.example.tes.admin.User.LoginResponse
import com.example.tes.admin.User.RegisterRequest
import com.example.tes.admin.User.RegisterResponse
import com.example.tes.admin.User.UserProfileResponse
import com.example.tes.admin.soal.GetResponeBatch
import com.example.tes.admin.soal.GetResponseSoal
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

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

    @POST("api/register")
    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("api/login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @Multipart
    @POST("api/lamar")
    fun kirimLamaran(
        @Part("user_id") userId: RequestBody,
        @Part("lowongan_id") lowonganId: RequestBody,
        @Part("nama") nama: RequestBody,
        @Part("email") email: RequestBody,
        @Part("telepon") telepon: RequestBody,
        @Part("pendidikan") pendidikan: RequestBody,
        @Part cv: MultipartBody.Part
    ): Call<LamaranResponse>



    @GET("api/cek-lamaran")
    fun cekLamaran(
        @Query("user_id") userId: Int,
        @Query("lowongan_id") lowonganId: Int
    ): Call<CekLamaranResponse>

    @GET("api/lamaran/user/{id}")
    fun getLamaranByUserId(@Path("id") userId: Int): Call<List<ModelDaftarLamaran>>

    @GET("api/lowongan/{id}/pendaftar")
    fun getPendaftarByLowongan(
        @Path("id") lowonganId: Int
    ): Call<GetPendaftarResponse>

    @GET("api/user-profile")
    fun getUserProfile(@Header("Authorization") token: String): Call<UserProfileResponse>

    @FormUrlEncoded
    @POST("api/user/update/{id}")
    fun updateUser(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @FieldMap data: Map<String, String>
    ): Call<ResponseBody>

}




