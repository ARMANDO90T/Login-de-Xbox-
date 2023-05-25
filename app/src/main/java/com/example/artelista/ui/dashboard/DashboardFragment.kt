package com.example.artelista.ui.dashboard
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.adapter.adapter_galeria
import com.example.artelista.databinding.FragmentDashboardBinding
import com.example.artelista.model.galeria

class DashboardFragment : Fragment() {

    private var fbinding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
          /* val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
           */
        fbinding = FragmentDashboardBinding.inflate(inflater, container, false)

        val view: View = binding.root

       // val textView: TextView = binding.textDashboard

       /* dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
       */
        val reciclergaleria :RecyclerView = fbinding!!.rvGaleria
        reciclergaleria.layoutManager = LinearLayoutManager(context)
        val adaptergaleria = adapter_galeria(getGaleria(),R.layout.item_galeria,Activity())
        reciclergaleria.adapter = adaptergaleria
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    fun getGaleria(): ArrayList<galeria> {
        //--------------
        val Galeria: ArrayList<galeria> = ArrayList<galeria>()
        //-------------

        Galeria.add(galeria("Minecraft", "17.69", "https://gaming-cdn.com/images/products/2369/616x353/minecraft-xbox-one-xbox-series-x-s-xbox-one-xbox-series-x-s-juego-microsoft-store-cover.jpg?v=1677838142", "Explora mundos generados aleatoriamente y construye cosas maravillosas, desde una simple casa hasta un fastuoso castillo."))
        Galeria.add(galeria("Resident Evil 4 Remake", "79,99", "https://www.somosxbox.com/wp-content/uploads/2022/06/FUR_uQAX0Asuiof-1170x658.jpg", "CAPCOM CO., LTD. • Acción y aventura"))
        Galeria.add(galeria("Resident Evil 6", "23.19", "https://images7.alphacoders.com/421/421814.jpg", "CAPCOM CO., LTD. • Acción y aventura"))
        Galeria.add(galeria("FIFA23", "66,90", "https://media.tycsports.com/files/2022/07/19/454313/fifa-23-portada_862x485.webp", "Electronic Arts Inc. • Simulación de fútbol"))
        Galeria.add(galeria("Fortnite", "Descarga gratuita", "https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_download_software_1/2x1_NSwitchDS_Fortnite_Chapter4_Season2_image1600w.jpg", "Esprinta, trepa y aplasta a tus rivales para conseguir la victoria magistral, ya sea construyendo en Battle Royale de Fortnite o sin hacerlo en Cero construcción de Fortnite."))
        return Galeria
    }

}