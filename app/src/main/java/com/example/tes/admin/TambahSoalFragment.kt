import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.ModelTambahSoal

class TambahSoalFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var soalAdapter: Adapter_TambahSoal
    private lateinit var soalList: MutableList<ModelTambahSoal>

    private lateinit var editPertanyaan: EditText
    private lateinit var editA: EditText
    private lateinit var editB: EditText
    private lateinit var editC: EditText
    private lateinit var editD: EditText
    private lateinit var editKunci: EditText
    private lateinit var btnSimpan: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_daftarsoal, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewsoalditambah)
        editPertanyaan = view.findViewById(R.id.editPertanyaan)
        editA = view.findViewById(R.id.editJawabanA)
        editB = view.findViewById(R.id.editJawabanB)
        editC = view.findViewById(R.id.editJawabanC)
        editD = view.findViewById(R.id.editJawabanD)
        editKunci = view.findViewById(R.id.editKunciJawaban)
        btnSimpan = view.findViewById(R.id.btnSimpanSoal)

        soalList = mutableListOf()

        soalAdapter = Adapter_TambahSoal(soalList,requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = soalAdapter

        btnSimpan.setOnClickListener {
            val pertanyaan = editPertanyaan.text.toString()
            val a = editA.text.toString()
            val b = editB.text.toString()
            val c = editC.text.toString()
            val d = editD.text.toString()
            val kunci = editKunci.text.toString()

            if (pertanyaan.isNotEmpty() && a.isNotEmpty() && b.isNotEmpty() && c.isNotEmpty() && d.isNotEmpty() && kunci.isNotEmpty()) {
                val soal = ModelTambahSoal(pertanyaan, a, b, c, d, kunci)
                soalList.add(soal)
                soalAdapter.notifyItemInserted(soalList.size - 1)
                clearForm()
            } else {
                Toast.makeText(requireContext(), "Isi semua field", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun clearForm() {
        editPertanyaan.text.clear()
        editA.text.clear()
        editB.text.clear()
        editC.text.clear()
        editD.text.clear()
        editKunci.text.clear()
    }
}
