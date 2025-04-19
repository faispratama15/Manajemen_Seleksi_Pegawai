import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.Admin_tambahbatchActivity
import com.example.tes.admin.ModelBatch

class Admin_SoalFragment() : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var batchAdapter: Admin_AdapterDaftarSoalSeleksi
    private lateinit var listBatch: List<ModelBatch>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_admin_form_tambah_soal, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewSoal)
        val btnTambah = view.findViewById<View>(R.id.btnTambahsoal)

        listBatch = listOf(
            ModelBatch("Soal Staff IT")
        )

        batchAdapter = Admin_AdapterDaftarSoalSeleksi(
            listBatch = listBatch,
            onLihatClick = { batch ->
                Toast.makeText(requireContext(), "Lihat ${batch.namaBatch}", Toast.LENGTH_SHORT).show()

            },
            onHapusClick = { batch ->
                Toast.makeText(requireContext(), "Hapus ${batch.namaBatch}", Toast.LENGTH_SHORT).show()

            },
            context
        )

        recyclerView.adapter = batchAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        btnTambah.setOnClickListener {
            val intent = Intent(requireContext(), Admin_tambahbatchActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
