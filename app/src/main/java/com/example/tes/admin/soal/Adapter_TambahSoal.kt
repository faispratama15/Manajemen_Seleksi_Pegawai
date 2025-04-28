package com.example.tes.admin.soal

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
import com.example.tes.admin.ModelSoal

class Adapter_TambahSoal(
    private val listSoal: List<ModelSoal>,
    private val context: Context
) : RecyclerView.Adapter<Adapter_TambahSoal.SoalViewHolder>() {


    inner class SoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtPertanyaan: TextView = itemView.findViewById(R.id.txtPertanyaan)
        val radioA: RadioButton = itemView.findViewById(R.id.radioA)
        val radioB: RadioButton = itemView.findViewById(R.id.radioB)
        val radioC: RadioButton = itemView.findViewById(R.id.radioC)
        val radioD: RadioButton = itemView.findViewById(R.id.radioD)
        val btnEdit: Button = itemView.findViewById(R.id.btnEditSoal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_admin_item_soalfor_admin, parent, false)
        return SoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: SoalViewHolder, position: Int) {
        val soal = listSoal[position]
        holder.txtPertanyaan.text = soal.soal
        holder.radioA.text = "A. ${soal.pil1}"
        holder.radioB.text = "B. ${soal.pil2}"
        holder.radioC.text = "C. ${soal.pil3}"
        holder.radioD.text = "D. ${soal.pil4}"

        holder.btnEdit.setOnClickListener {
            context.startActivity(Intent(context, Admin_editSoalActivity::class.java))
        }
    }

    override fun getItemCount(): Int = listSoal.size
}
