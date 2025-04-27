import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.ApiClient
import com.example.tes.admin.ModelTambahSoal
import com.example.tes.admin.soal.Adapter_TambahSoal
import com.example.tes.admin.soal.SoalRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TambahSoalFragment : Fragment() {

    val ApiService = ApiClient.instance


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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_daftarsoal, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewsoalditambah)
        editPertanyaan = view.findViewById(R.id.editPertanyaan2)
        editA = view.findViewById(R.id.editJawabanA2)
        editB = view.findViewById(R.id.editJawabanB2)
        editC = view.findViewById(R.id.editJawabanC2)
        editD = view.findViewById(R.id.editJawabanD2)
        editKunci = view.findViewById(R.id.editKunciJawaban2)
        btnSimpan = view.findViewById(R.id.btnSimpanSoal2)

        soalList = mutableListOf()

        soalAdapter = Adapter_TambahSoal(soalList,requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = soalAdapter

        lifecycleScope.launch {
            val batchId = 1
            val response = ApiClient.instance.getSoalByBatch(batchId)
            if (response.isSuccessful) {
                val listSoal = response.body()
                if (listSoal != null) {
                    soalList.clear()

                    val mappedList = listSoal.map { soal ->
                        ModelTambahSoal(
                            soal.pertanyaan,
                            soal.jawaban_a,
                            soal.jawaban_b,
                            soal.jawaban_c,
                            soal.jawaban_d,
                            soal.jawaban_benar
                        )
                    }

                    soalList.addAll(mappedList)
                    soalAdapter.notifyDataSetChanged()
                }
            } else {
                Log.e("API", "Gagal load soal: ${response.message()}")
            }
        }
        fun getBatchIdFromArguments(): Int {
            return arguments?.getInt("batch_id") ?: 0
        }
        btnSimpan.setOnClickListener {
            val pertanyaan = editPertanyaan.text.toString()
            val a = editA.text.toString()
            val b = editB.text.toString()
            val c = editC.text.toString()
            val d = editD.text.toString()
            val kunci = editKunci.text.toString()

            val batchId = arguments?.getInt("batch_id") ?: 0

            if (pertanyaan.isNotEmpty() && a.isNotEmpty() && b.isNotEmpty() && c.isNotEmpty() && d.isNotEmpty() && kunci.isNotEmpty()) {

                val soalRequest = SoalRequest(
                    pertanyaan = pertanyaan,
                    jawaban_a = a,
                    jawaban_b = b,
                    jawaban_c = c,
                    jawaban_d = d,
                    jawaban_benar = kunci,
                    batch_id = batchId
                )

                CoroutineScope(Dispatchers.IO).launch {
                    val response = ApiService.addSoal(soalRequest)

                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            Toast.makeText(requireContext(), "Soal berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                            soalList.add(ModelTambahSoal(pertanyaan, a, b, c, d, kunci))
                            soalAdapter.notifyItemInserted(soalList.size - 1)
                            clearForm()
                        } else {
                            Toast.makeText(requireContext(), "Gagal menambahkan soal", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Isi semua field", Toast.LENGTH_SHORT).show()
            }
        }

        fun getSoalFromApi(batchId: Int) {
            CoroutineScope(Dispatchers.IO).launch {
                val response = ApiService.getSoalByBatch(batchId)
                if (response.isSuccessful) {
                    val listSoal = response.body() ?: emptyList()
                    withContext(Dispatchers.Main) {
                        soalList.clear()
                        listSoal.forEach { soalResponse ->
                            soalList.add(
                                ModelTambahSoal(
                                    soalResponse.pertanyaan,
                                    soalResponse.jawaban_a,
                                    soalResponse.jawaban_b,
                                    soalResponse.jawaban_c,
                                    soalResponse.jawaban_d,
                                    soalResponse.jawaban_benar
                                )
                            )
                        }
                        soalAdapter.notifyDataSetChanged()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Gagal mengambil soal", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            fun getBatchIdFromArguments(): Int {
                return arguments?.getInt("batch_id") ?: 0
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
