package com.example.artelista.ui.Artista
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.adapter.adapterartista
import com.example.artelista.databinding.FragmentArtistaBinding
import com.example.artelista.model.artista

class ArtistaFragment : Fragment() {

    private var fbinding: FragmentArtistaBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        fbinding = FragmentArtistaBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val reciclerartista : RecyclerView = fbinding!!.rvArtista
        reciclerartista.layoutManager = LinearLayoutManager(context)
        val adapterartista = adapterartista(getArtistas(), R.layout.item_artista, Activity())
        reciclerartista.adapter = adapterartista
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null

    }

    fun getArtistas(): ArrayList<artista> {
        //--------------
        val artistas: ArrayList<artista> = ArrayList()
        //-------------
        artistas.add(artista("Selim", "Online", "Nicaragua"))
        artistas.add(artista("ARMANDO OREO", "Online", "Nicaragua"))
        artistas.add(artista("Ozaba", "Online", "Nicaragua"))
        artistas.add(artista("Apfrostt", "Online", "Nicaragua"))
        artistas.add(artista("Eze3103", "Online", "Nicaragua"))
        artistas.add(artista("Chino", "Online", "El Salvador"))
        artistas.add(artista("Conewar12345", "Online", "Nicaragua"))
        artistas.add(artista("Messi", "Online", "Nicaragua"))
        artistas.add(artista("Eliu", "Online", "Nicaragua"))
        artistas.add(artista("Kevin S", "Online", "Nicaragua"))
        artistas.add(artista("Dylan", "Online", "Nicaragua"))
        artistas.add(artista("German", "Online", "Nicaragua"))
        artistas.add(artista("Yair", "Online", "Nicaragua"))
        artistas.add(artista("Eysi Jose", "Online", "Nicaragua"))
        artistas.add(artista("Jocote con sal", "Online", "EEUU"))
        return artistas
    }

}