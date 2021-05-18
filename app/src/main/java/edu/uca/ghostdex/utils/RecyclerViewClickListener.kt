package edu.uca.ghostdex.utils

import edu.uca.ghostdex.model.Pkmn

/**Interfaz para detectar cuando un usuario hace
 * click o tap sobre un pokémon*/
interface RecyclerViewClickListener {
    fun onClickPkmn(position: Int, pkmn:Pkmn)
}