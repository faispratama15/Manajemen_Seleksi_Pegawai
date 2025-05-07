package com.example.tes.admin.User

import retrofit2.Callback
import retrofit2.Response
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tes.LoginActivity
import com.example.tes.R
import com.example.tes.admin.ApiClient

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profil, container, false)

        val txtNama = view.findViewById<TextView>(R.id.txtNama)
        val txtEmail = view.findViewById<TextView>(R.id.txtEmail)
        val txtTelepon = view.findViewById<TextView>(R.id.txtTelepon)
        val btnEdit = view.findViewById<Button>(R.id.btnEditProfil)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        val sharedPref = requireActivity().getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val token = sharedPref.getString("token", null)

        Log.d("ProfileFragment", "Token: $token")

        if (token.isNullOrEmpty()) {

            navigateToLogin()
            return view
        }

        ApiClient.instance.getUserProfile("Bearer $token").enqueue(object : Callback<UserProfileResponse> {
            override fun onResponse(call: Call<UserProfileResponse>, response: Response<UserProfileResponse>) {
                if (response.isSuccessful) {
                    val userProfile = response.body()?.data
                    if (userProfile != null) {

                        txtNama.text = userProfile.nama ?: "Nama tidak ditemukan"
                        txtEmail.text = userProfile.email ?: "Email tidak ditemukan"
                        txtTelepon.text = userProfile.no_hp ?: "Telepon tidak ditemukan"
                    } else {
                        Toast.makeText(requireContext(), "Data profil tidak lengkap", Toast.LENGTH_SHORT).show()
                    }
                } else {

                    Log.e("ProfileFragment", "Error: ${response.errorBody()?.string()}")
                    Toast.makeText(requireContext(), "Gagal mengambil data profil. Coba lagi.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserProfileResponse>, t: Throwable) {

                Log.e("ProfileFragment", "Error: ${t.message}")
                Toast.makeText(requireContext(), "Terjadi kesalahan: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        // Tombol Edit Profil
        btnEdit.setOnClickListener {
            val intent = Intent(requireContext(), EditProfilActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            logout(sharedPref)
        }

        return view
    }

    private fun navigateToLogin() {
        val intent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun logout(sharedPref: SharedPreferences) {
        sharedPref.edit().clear().apply()

        Toast.makeText(requireContext(), "Anda telah logout", Toast.LENGTH_SHORT).show()

        view?.postDelayed({
            navigateToLogin()
        }, 1000)
    }
}
