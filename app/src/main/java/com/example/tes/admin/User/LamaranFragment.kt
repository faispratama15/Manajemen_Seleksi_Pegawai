import android.content.Context
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.R
import com.example.tes.admin.ApiClient
import com.example.tes.admin.User.AdapterLamaran
import com.example.tes.admin.User.ModelDaftarLamaran

class LamaranFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterLamaran
    private var daftarLamaran: ArrayList<ModelDaftarLamaran> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lamaran_saya, container, false)
        recyclerView = view.findViewById(R.id.recyclerLamaran)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt("user_id", -1)

        if (userId != -1) {
            getDataLamaran(userId)
        }

        return view
    }

    private fun getDataLamaran(userId: Int) {

        val client = ApiClient.instance.getLamaran(userId)
        client.enqueue(object : Callback<LamaranResponse> {
            override fun onResponse(
                call: Call<LamaranResponse>,
                response: Response<LamaranResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!.data
                    val newData = data.map {
                        ModelDaftarLamaran(
                            posisi = it.lowongan?.nama ?: "Tanpa Posisi",
                            Perusahaan = it.lowongan?.perusahaan ?: "Tanpa Perusahaan",
                            ModelDaftarLowongan_id = it.id
                        )
                    }

                    daftarLamaran.clear()
                    daftarLamaran.addAll(newData)
                    adapter = AdapterLamaran(daftarLamaran, requireContext())
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<LamaranResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Gagal memuat data: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
