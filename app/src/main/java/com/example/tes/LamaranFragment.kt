import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.AdapterDaftarLowongan
import com.example.tes.AdapterLamaran
import com.example.tes.ModelDaftarLamaran
import com.example.tes.ModelDaftarLowongan
import com.example.tes.R

class LamaranFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        containerView: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lamaran_saya, containerView,false)

        val rclview = view.findViewById<RecyclerView>(R.id.recyclerLamaran)

        val lamaranlist: MutableList<ModelDaftarLamaran> = ArrayList()
        lamaranlist.add(
            ModelDaftarLamaran(
                posisi = "staff",
                Perusahaan = "PT.IKER",
                status = "Lulus"
            )
            )

        rclview.layoutManager= LinearLayoutManager(activity as Context)
        val adapter= AdapterLamaran(lamaranlist, activity as Context)
        rclview.adapter = adapter

        return view
    }

}