import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.Admin_SuksesKirim
import com.example.tes.admin.ModelBatch

class Adapter_daftarSoalForuser(
    private val soalList: List<ModelBatch>,
    private val context: Context
) : RecyclerView.Adapter<Adapter_daftarSoalForuser.SoalViewHolder>() {

    inner class SoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNamaBatch: TextView = itemView.findViewById(R.id.txtNamaBatch)
        val btnMulai: Button = itemView.findViewById(R.id.btnMulaisoal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_soal_dariadmin_untukuser, parent, false)
        return SoalViewHolder(view)

    }

    override fun onBindViewHolder(holder: SoalViewHolder, position: Int) {
        val soal = soalList[position]
        holder.txtNamaBatch.text = soal.namaBatch

        holder.btnMulai.setOnClickListener {
            context.startActivity(Intent(context,Admin_SuksesKirim::class.java))
            context as Activity
            context.finish()
        }
    }

    override fun getItemCount(): Int = soalList.size
}
