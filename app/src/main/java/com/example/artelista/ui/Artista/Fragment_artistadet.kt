package com.example.artelista.ui.Artista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.artelista.R
import com.example.artelista.databinding.FragmentArtistadetBinding


class Fragment_artistadet : Fragment() {

    private var fbinding: FragmentArtistadetBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fbinding = FragmentArtistadetBinding.inflate(inflater, container, false)
        val view : View =  binding.root


        val toolbar: Toolbar = fbinding!!.tbArtistaDet

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_left)
        toolbar.title = "Datos del jugador"
        toolbar.setNavigationOnClickListener{
            Navigation.findNavController(it).navigateUp()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        fbinding = null
    }

}