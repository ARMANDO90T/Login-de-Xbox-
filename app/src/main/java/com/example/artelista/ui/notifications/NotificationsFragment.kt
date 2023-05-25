package com.example.artelista.ui.notifications

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.R
import com.example.artelista.adapter.adapterevento
import com.example.artelista.databinding.FragmentNotificationsBinding
import com.example.artelista.model.evento


class NotificationsFragment : Fragment() {

    private var fbinding: FragmentNotificationsBinding? = null

    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)
        */
        fbinding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        //val textView: TextView = binding.textNotifications
       /* notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        val reciclerevento : RecyclerView = fbinding!!.rvEvento
        reciclerevento.layoutManager = LinearLayoutManager(context)
        val adapterevento = adapterevento(getEvento(), R.layout.item_evento, Activity())
        reciclerevento.adapter = adapterevento
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    fun getEvento(): ArrayList<evento> {
        //--------------
        val Evento: ArrayList<evento> = ArrayList<evento>()
        //-------------
        Evento.add(evento("Selim", "Nicaragua", "8:00"))
        Evento.add(evento("ARMANDO OREO", "Nicaragua", "10:00"))
        Evento.add(evento("Apfrostt", "Nicaragua", "03:00"))
        Evento.add(evento("Eze3103", "Nicaragua", "11:00"))
        Evento.add(evento("Ozaba", "Nicaragua", "04:00"))
        Evento.add(evento("yair", "Nicaragua", "8:00"))
        Evento.add(evento("Germna", "Nicaragua", "10:00"))
        Evento.add(evento("Jocote con sal", "EEUU", "03:00"))
        Evento.add(evento("Messi", "Nicaragua", "11:00"))
        Evento.add(evento("Chino", "El Salvador", "04:00"))
        Evento.add(evento("Conewar12345", "Nicaragua", "8:00"))
        Evento.add(evento("Dylan", "Nicaragua", "10:00"))
        Evento.add(evento("Eysi Jose", "Nicaragua", "03:00"))
        Evento.add(evento("Kevin S", "Nicaragua", "11:00"))
        Evento.add(evento("Eliu", "Nicaragua", "04:00"))
        return Evento
    }

}