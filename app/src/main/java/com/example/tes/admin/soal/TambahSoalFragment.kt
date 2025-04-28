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
import com.example.tes.admin.ModelSoal
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
    private lateinit var soalList: MutableList<ModelSoal>

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

        return view
    }
}
