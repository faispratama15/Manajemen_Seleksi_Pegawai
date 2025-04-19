import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.Admin_LihatsoalForUser
import com.example.tes.admin.ModelBatch

class Admin_AdapterDaftarSoalSeleksi(
    private val listBatch: List<ModelBatch>,
    private val onLihatClick: (ModelBatch) -> Unit,
    private val onHapusClick: (ModelBatch) -> Unit,
    private val context: Context?
) : RecyclerView.Adapter<Admin_AdapterDaftarSoalSeleksi.BatchViewHolder>() {

    inner class BatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNamaBatch: TextView = itemView.findViewById(R.id.txtNamaBatch)
        val btnLihatBatch: Button = itemView.findViewById(R.id.btnlihatBatch)
        val btnHapusBatch: Button = itemView.findViewById(R.id.btnHapusBatch)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daftarsoal, parent, false)
        return BatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BatchViewHolder, position: Int) {
        val batch = listBatch[position]
        holder.txtNamaBatch.text = batch.namaBatch


        holder.btnLihatBatch.setOnClickListener {
            context?.startActivity(Intent(context, Admin_LihatsoalForUser::class.java))
            onLihatClick(batch)
        }

        holder.btnHapusBatch.setOnClickListener {
            onHapusClick(batch)
        }
    }

    override fun getItemCount(): Int = listBatch.size
}
