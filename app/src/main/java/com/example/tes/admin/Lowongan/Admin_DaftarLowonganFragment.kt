package com.example.tes.admin.Lowongan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.admin.User.ModelDaftarLowongan
import com.example.tes.R
import com.example.tes.admin.ApiClient
import com.example.tes.admin.ResponseLowongan
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Admin_DaftarLowonganFragment : Fragment() {
    companion object {
        var isEdit: Boolean = false
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Admin_AdapterDaftarLowongan
    private var dataLowongan = mutableListOf<ModelDaftarLowongan>()

    override fun onCreateView(
        inflater: LayoutInflater,
        containerView: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_admin_daftar_lowongan, containerView, false)

        recyclerView = view.findViewById(R.id.recyclerViewLowonganforAdmin)
        val btnTambah = view.findViewById<FloatingActionButton>(R.id.fabTambah)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = Admin_AdapterDaftarLowongan(dataLowongan, requireContext())
        recyclerView.adapter = adapter

        loadLowonganData()

        btnTambah.setOnClickListener {
            val intent = Intent(requireActivity(), Admin_TambahLowongan::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        loadLowonganData()
    }

    private fun loadLowonganData() {
        ApiClient.instance.getLowongan().enqueue(object : Callback<ResponseLowongan> {
            override fun onResponse(call: Call<ResponseLowongan>, response: Response<ResponseLowongan>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    val newData = response.body()?.data ?: emptyList()
                    dataLowongan.clear()
                    dataLowongan.addAll(newData)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(requireContext(), "Gagal ambil data", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ResponseLowongan>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}