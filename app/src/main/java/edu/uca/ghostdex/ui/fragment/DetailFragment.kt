package edu.uca.ghostdex.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import edu.uca.ghostdex.R
import edu.uca.ghostdex.ui.MainActivity


private const val ARG_NOMBRE = "nombre"
private const val ARG_DESCRIPCION = "descripcion"

class DetailFragment : DialogFragment() {
    private var nombre: String? = null
    private var descripcion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nombre = it.getString(ARG_NOMBRE)
            descripcion = it.getString(ARG_DESCRIPCION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup(view, nombre, descripcion);
    }

    companion object {
        fun newInstance(nombre: String?, descripcion: String?) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NOMBRE, nombre)
                    putString(ARG_DESCRIPCION, descripcion)
                }
            }
    }

    private fun setup(view: View, nombre: String?, descripcion: String?) {
        val tvNombre = view.findViewById<TextView>(R.id.pkmnname)
        val tvDescripcion = view.findViewById<TextView>(R.id.description)
        val IvImg: ImageView = view.findViewById(R.id.pkmn_image)

        tvNombre.text = nombre
        tvDescripcion.text = descripcion
        val btnOk: Button = view.findViewById(R.id.btn_ok)
        btnOk.setOnClickListener(View.OnClickListener {
            dismiss()
            val intent = Intent(context, MainFragment::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        })
    }
}