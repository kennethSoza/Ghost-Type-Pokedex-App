package edu.uca.ghostdex.utils

import edu.uca.ghostdex.model.Pkmn
import java.lang.Exception

sealed class DataState{
    object Idle:DataState()
    data class Success(val pkmn:List<Pkmn>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}
