package com.example.tes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDaftarLowongan (
    private val mlist: List<ModelDaftarLowongan>,
    private val context: Context
) : RecyclerView.Adapter<AdapterDaftarLowongan.ViewHolder>(){
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val nmlowongan: TextView = itemView.findViewById(R.id.txtPosisi)
        val nmperusahaan: TextView = itemView.findViewById(R.id.txtPerusahaan)
        val nmlokasi: TextView = itemView.findViewById(R.id.txtLokasi)
        val btnlhtdetail = itemView.findViewById<Button>(R.id.btnDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.design_tampilan_lowongan, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mlist[position]
        holder.nmlowongan.text = item.nama
        holder.nmperusahaan.text= item.perusahaan
        holder.nmlokasi.text= item.lokasi

        holder.btnlhtdetail.setOnClickListener {
            context.startActivity(Intent(context, DetailLowonganActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}

