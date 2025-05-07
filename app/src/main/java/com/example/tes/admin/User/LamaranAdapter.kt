package com.example.tes.admin.User

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class LamaranAdapter(private val lamaranList: List<ModelDaftarLamaran>, requireContext: Context) :
    RecyclerView.Adapter<LamaranAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val posisiText: TextView = view.findViewById(R.id.tvNamaPosisi)
        val perusahaanText: TextView = view.findViewById(R.id.tvPerusahaan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lamaran, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lamaran = lamaranList[position]
        Log.d("LamaranAdapter", "Posisi: ${lamaran.lowongan.posisi}, Perusahaan: ${lamaran.lowongan.perusahaan}")

        holder.posisiText.text = lamaran.lowongan.posisi
        holder.perusahaanText.text = lamaran.lowongan.perusahaan
    }

    override fun getItemCount(): Int = lamaranList.size
}

