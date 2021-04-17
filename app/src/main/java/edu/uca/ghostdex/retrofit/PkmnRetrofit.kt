package edu.uca.ghostdex.retrofit


import retrofit2.http.GET

interface PkmnRetrofit {
    @GET("ghost-api")
    suspend fun get () : List<PkmnNetworkEntity>
}