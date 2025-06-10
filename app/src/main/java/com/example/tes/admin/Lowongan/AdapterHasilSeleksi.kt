package com.example.tes.admin.Lowongan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class AdapterHasilSeleksi(
    private val mlist: List<ModelHasilSeleksi>,
    private val context: Context
) : RecyclerView.Adapter<AdapterHasilSeleksi.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama = itemView.findViewById<TextView>(R.id.namaHasil)
        val skor = itemView.findViewById<TextView>(R.id.skorHasil)
        val status = itemView.findViewById<TextView>(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_hasil_seleksi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mlist[position]
        holder.nama.text = data.nama
        holder.skor.text = "Skor: ${data.skor}"
        holder.status.text ="Status: ${data.status}"
    }

    override fun getItemCount(): Int = mlist.size
}