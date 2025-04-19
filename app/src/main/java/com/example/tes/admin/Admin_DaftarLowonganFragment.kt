import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tes.ModelDaftarLowongan
import com.example.tes.R
import com.example.tes.admin.Admin_AdapterDaftarLowongan
import com.example.tes.admin.Admin_TambahLowongan
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Admin_DaftarLowonganFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        containerView: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_admin_daftar_lowongan, containerView,false)

        val rclview = view.findViewById<RecyclerView>(R.id.recyclerViewLowonganforAdmin)

        val lamaranlist: MutableList<ModelDaftarLowongan> = ArrayList()
        lamaranlist.add(
            ModelDaftarLowongan(
                lowongan = "staff",
                Perusahaan = "PT.IKER",
                lokasi = "Antang"
            )
        )

        rclview.layoutManager= LinearLayoutManager(activity as Context)
        val adapter= Admin_AdapterDaftarLowongan(lamaranlist, activity as Context)
        rclview.adapter = adapter

        val btntambah = view.findViewById<FloatingActionButton>(R.id.fabTambah)

        btntambah.setOnClickListener {
            val intent = Intent(requireActivity(), Admin_TambahLowongan::class.java)
            startActivity(intent)
        }

        return view
    }

}