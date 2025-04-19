package com.example.tes.admin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R

class Admin_Adapter_lihatsoalforuser(
    private val listSoal: List<ModelTambahSoal>,
    private val context: Context
)   : RecyclerView.Adapter<Admin_Adapter_lihatsoalforuser.SoalViewHolder>() {


    inner class SoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtPertanyaan: TextView = itemView.findViewById(R.id.txtPertanyaan)
        val radioA: RadioButton = itemView.findViewById(R.id.radioAa)
        val radioB: RadioButton = itemView.findViewById(R.id.radioBa)
        val radioC: RadioButton = itemView.findViewById(R.id.radioCa)
        val radioD: RadioButton = itemView.findViewById(R.id.radioDa)
        val btnEdit: Button = itemView.findViewById(R.id.btnEditSoala)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_admin_editsoal_foradmin, parent, false)
        return SoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: SoalViewHolder, position: Int) {
        val soal = listSoal[position]
        holder.txtPertanyaan.text = soal.pertanyaan
        holder.radioA.text = "A. ${soal.jawabanA}"
        holder.radioB.text = "B. ${soal.jawabanB}"
        holder.radioC.text = "C. ${soal.jawabanC}"
        holder.radioD.text = "D. ${soal.jawabanD}"

        holder.btnEdit.setOnClickListener {
            context.startActivity(Intent(context,Admin_editSoalActivity::class.java))
        }
    }

    override fun getItemCount(): Int = listSoal.size
}
