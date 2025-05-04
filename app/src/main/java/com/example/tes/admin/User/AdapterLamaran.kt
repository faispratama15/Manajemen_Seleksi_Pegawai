package com.example.tes.admin.User

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class AdapterLamaran(
    private val list: List<ModelDaftarLamaran>,
    private val context: Context
) : RecyclerView.Adapter<AdapterLamaran.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posisi = itemView.findViewById<TextView>(R.id.tvNamaPosisi)
        val perusahaan = itemView.findViewById<TextView>(R.id.tvPerusahaan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_lamaran, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lamaran = list[position]
        holder.posisi.text = lamaran.posisi
        holder.perusahaan.text = lamaran.Perusahaan
    }

    override fun getItemCount() = list.size
}

