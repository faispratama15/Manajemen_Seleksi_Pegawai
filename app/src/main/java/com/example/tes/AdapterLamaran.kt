package com.example.tes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterLamaran (
    private val mlist: List<ModelDaftarLamaran>,
    private val context: Context
) : RecyclerView.Adapter<AdapterLamaran.ViewHolder>(){
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val nmposisi: TextView = itemView.findViewById(R.id.tvNamaPosisi)
        val nmperusahaan: TextView = itemView.findViewById(R.id.tvPerusahaan)
        val nmstatus: TextView = itemView.findViewById(R.id.tvStatus)
        val btnsoal: Button = itemView.findViewById(R.id.btnSoal)
        val btnHasil: Button = itemView.findViewById(R.id.btnLhtHasil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lamaran, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mlist[position]
        holder.nmposisi.text = item.posisi
        holder.nmperusahaan.text= item.Perusahaan
        holder.nmstatus.text= item.status

        holder.btnsoal.setOnClickListener {
            context.startActivity(Intent(context,DaftarSoalAcvtivity::class.java))
        }

        holder.btnHasil.setOnClickListener {
            context.startActivity(Intent(context,HasilActivity::class.java))
        }

    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}
