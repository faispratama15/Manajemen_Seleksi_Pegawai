
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.AdapterDaftarLowongan
import com.example.tes.ModelDaftarLowongan
import com.example.tes.R

class Fragmentdaftarlowongan : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        containerView: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.daftar_lowongan, containerView,false)

        val rclview = view.findViewById<RecyclerView>(R.id.recyclerViewLowongan)

        val lowonganlist: MutableList<ModelDaftarLowongan> = ArrayList()
        lowonganlist.add(
            ModelDaftarLowongan(
                lowongan = "staff",
                Perusahaan = "PT.IKER",
                lokasi = "Antang"
            )
        )

        rclview.layoutManager= LinearLayoutManager(activity as Context)
        val adapter= AdapterDaftarLowongan(lowonganlist, activity as Context)
        rclview.adapter = adapter

        return view
    }
}

