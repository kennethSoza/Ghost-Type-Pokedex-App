package edu.uca.ghostdex.room

import edu.uca.ghostdex.model.Pkmn
import edu.uca.ghostdex.utils.EntityMapper
import edu.uca.ghostdex.retrofit.PkmnNetworkEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<PkmnCacheEntity, Pkmn>{

    override fun mapFromEntity(entity: PkmnCacheEntity): Pkmn {
        return Pkmn(
            id = entity.id,
            pkdxnumber = entity.pkdxnumber,
            pkmnname = entity.pkmnname,
            description = entity.description,
            url = entity.url
        )
    }

    override fun mapToEntity(domainModel: Pkmn): PkmnCacheEntity {
        return PkmnCacheEntity(
            id = domainModel.id,
            pkdxnumber = domainModel.pkdxnumber,
            pkmnname = domainModel.pkmnname,
            description = domainModel.description,
            url = domainModel.url
        )
    }

    fun mapFromEntityList(entities: List<PkmnCacheEntity>): List<Pkmn>{
        return entities.map { mapFromEntity(it) }
    }
}