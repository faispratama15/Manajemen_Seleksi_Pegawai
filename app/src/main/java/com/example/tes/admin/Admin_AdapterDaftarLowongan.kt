package com.example.tes.admin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.ModelDaftarLowongan
import com.example.tes.R

class Admin_AdapterDaftarLowongan(
    private val mlist: List<ModelDaftarLowongan>,
    private val context: Context
) : RecyclerView.Adapter<Admin_AdapterDaftarLowongan.ViewHolder>(){
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val nmlowongan: TextView = itemView.findViewById(R.id.txtPosisi)
        val nmperusahaan: TextView = itemView.findViewById(R.id.txtPerusahaan)
        val nmlokasi: TextView = itemView.findViewById(R.id.txtLokasi)
        val btnlhtdetail = itemView.findViewById<Button>(R.id.btnDetail)
        val btnedit = itemView.findViewById<Button>(R.id.btnEditLowongan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_admin_item_lowongan, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mlist[position]
        holder.nmlowongan.text = item.lowongan
        holder.nmperusahaan.text= item.Perusahaan
        holder.nmlokasi.text= item.lokasi

        holder.btnlhtdetail.setOnClickListener {
            context.startActivity(Intent(context, Admin_DetailLowonganActivity::class.java))
        }

        holder.btnedit.setOnClickListener {
            context.startActivity(Intent(context, Admin_EditLowongan::class.java))
        }

    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}

