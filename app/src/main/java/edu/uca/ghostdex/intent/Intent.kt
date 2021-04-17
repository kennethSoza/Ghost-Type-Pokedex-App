package edu.uca.ghostdex.intent

sealed class Intent{
    object GetPkmnEvent: Intent()
    object None: Intent()
}
