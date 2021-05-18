package edu.uca.ghostdex.utils

import edu.uca.ghostdex.model.Pkmn

interface RecyclerViewClickListener {
    fun onClickPkmn(position: Int, pkmn:Pkmn)
}