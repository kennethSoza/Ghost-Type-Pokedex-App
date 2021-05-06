package edu.uca.ghostdex.repository

import edu.uca.ghostdex.model.Pkmn
import edu.uca.ghostdex.retrofit.NetworkMapper
import edu.uca.ghostdex.retrofit.PkmnRetrofit
import edu.uca.ghostdex.room.CacheMapper
import edu.uca.ghostdex.room.PkmnDao
import edu.uca.ghostdex.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.net.UnknownHostException

class PkmnRepository constructor (
        private val pkmnDao : PkmnDao,
        private val pkmnRetrofit: PkmnRetrofit,
        private val cacheMapper: CacheMapper,
        private val networkMapper: NetworkMapper
        ){
        suspend fun getPkmn(): Flow<DataState> = flow{
                emit(DataState.Loading)
                delay(2000)
                try {
                        val pkmnData = pkmnRetrofit.get()
                        val pkmnMap = networkMapper.mapFromEntityList(pkmnData)
                        for (tempPkmn in pkmnMap){
                                pkmnDao.insert(cacheMapper.mapToEntity(tempPkmn))
                        }
                        val cachePkmn = pkmnDao.get()
                        emit(DataState.Success(cacheMapper.mapFromEntityList(cachePkmn)))
                }catch (e: Exception){
                        when(e){
                                is UnknownHostException -> {
                                        val cachePkmn = pkmnDao.get()
                                        if (cachePkmn.isEmpty()) {
                                                emit(DataState.Error(java.lang.Exception("The" +
                                                        " table is empty,, please connect to" +
                                                        " internet")))
                                        }else{
                                                emit(DataState.Success(cacheMapper.mapFromEntityList(cachePkmn)))
                                        }
                                }
                        }
                        emit(DataState.Error(e))
                }
        }

}
