package com.example.tes.admin
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
class Admin_AdapterDaftarPendaftar(
    private val mlist: List<Modelpendaftar>,
    private val context: Context
) : RecyclerView.Adapter<Admin_AdapterDaftarPendaftar.ViewHolder>(){
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val nama: TextView = itemView.findViewById(R.id.txtNamaPendaftar)
        val btnlihatdetail = itemView.findViewById<Button>(R.id.btnLihatDetail)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_admin_item_pendaftaran, parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mlist[position]
        holder.nama.text = item.namalengkap


        holder.btnlihatdetail.setOnClickListener {
            context.startActivity(Intent(context, Admin_DetailPelamarActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}

