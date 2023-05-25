package com.example.artelista
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.artelista.databinding.ActivityCrearcuentaBinding
import com.google.firebase.auth.FirebaseAuth

class activity_crearcuenta : AppCompatActivity() {
    private lateinit var binding: ActivityCrearcuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //------
        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        val view = binding.root
        //------
        setContentView(view)






        val toolbar: Toolbar = binding.tbCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Crear Cuenta"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.btnCrearCuenta.setOnClickListener {
            if (valida().equals(true)) {
                addCuentaUsuario()

            }
        }
    }

    fun valida(): Boolean {
        try {
            var validaok: Boolean = false

            //-- El email es un valor requerido

            if (binding.tvEmailCuenta.text?.length?.equals(0)!!) {
                binding.tvEmailCuenta.requestFocus()
                binding.tvEmailCuenta.setError("Email es un valor requerido")
                return validaok
            }

            //-- La contraseña es un valor requerido
            if (binding.tvPasswordCuenta.text?.length?.equals(0)!!) {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("Debe ingresar una contraseña")
                return validaok
            }

            //La confirmación de contraseña es un valor requerido
            if (binding.tvConfPassword.text?.length?.equals(0)!!) {
                binding.tvConfPassword.requestFocus()

                binding.tvConfPassword.setError("Debe ingresar la confirmación de contraseña")
                return validaok
            }

            //La contraseña debe ser igual a la confirmación de la contraseña
            val strpassword: String = if (binding.tvPasswordCuenta.text !=
                null
            ) binding.tvPasswordCuenta.text.toString() else ""
            val strpasswordconfirmar: String = if (binding.tvConfPassword.text
                != null
            ) binding.tvConfPassword.text.toString() else ""

            if (strpassword.equals(strpasswordconfirmar) == false) {
                binding.tvPasswordCuenta.requestFocus()
                binding.tvPasswordCuenta.setError("El Password y la confirmación deben coincidir")
                return validaok
            }
            validaok = true
            return validaok

        } catch (e: Exception) {
            e.message?.let { Log.e("Error en valida", it) };
            return false;
        }
    }


//-- Metodo agregar Usuario


    fun addCuentaUsuario() {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.createUserWithEmailAndPassword(
            binding.tvEmailCuenta.text
                .toString(), binding.tvPasswordCuenta.text.toString()
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(
                    this, "El usuario ha sido creado",
                    Toast.LENGTH_SHORT
                ).show();
                finish()
            } else {
                Toast.makeText(
                    this, "El usuario no ha sido creado",
                    Toast.LENGTH_SHORT
                ).show();

            }
        }
    }
}