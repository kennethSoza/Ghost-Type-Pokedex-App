package edu.uca.ghostdex.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.squareup.picasso.Picasso
import edu.uca.ghostdex.R
import edu.uca.ghostdex.model.Pkmn
import kotlinx.android.synthetic.main.fragment_details_pokemon.view.*
import kotlinx.android.synthetic.main.item_pokemon.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [details_pokemon.newInstance] factory method to
 * create an instance of this fragment.
 */

/**Fragment que extiende de DialogFragment, este muestra los detalles
 * del pokemon seleccionado en la lista del recyclerview*/
class DetailsPokemon : DialogFragment() {
    var pkmnSelected: Pkmn? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView: View = inflater.inflate(R.layout.fragment_details_pokemon, container, false)


        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val pkdxnumberFragment: TextView = view.pkdxnumberFragment
        val pkmnnameFragment: TextView = view.pkmnnameFragment
        val descriptonFragment: TextView = view.descriptionFragment
        val pkmnImageFragment: ImageView = view.pkmn_imageFragment

        pkdxnumberFragment.text = "#"+pkmnSelected?.pkdxnumber
        pkmnnameFragment.text = pkmnSelected?.pkmnname
        descriptonFragment.text = pkmnSelected?.description
        Picasso.get()
                .load(pkmnSelected?.url)
                .into(pkmnImageFragment)
        pkmnSelected?.pkmnname?.let { Log.d("Probando ViewCreated", it) }
    }


    fun setPkmnDetail(pkmn: Pkmn){
        pkmnSelected = pkmn
        pkmnSelected?.pkmnname?.let { Log.d("Probando setPkmnDetail", it) }
    }


}