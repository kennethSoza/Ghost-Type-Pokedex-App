package edu.uca.ghostdex.retrofit

import javax.inject.Inject
import edu.uca.ghostdex.model.Pkmn
import edu.uca.ghostdex.utils.EntityMapper

class NetworkMapper
@Inject
constructor() : EntityMapper<PkmnNetworkEntity, Pkmn>{
    override fun mapFromEntity(entity: PkmnNetworkEntity): Pkmn {
        return Pkmn(
            id = entity.id,
            pkdxnumber = entity.pkdxnumber,
            pkmnname = entity.pkmnname,
            description = entity.description,
            url = entity.url
        )
    }

    override fun mapToEntity(domainModel: Pkmn): PkmnNetworkEntity {
        return  PkmnNetworkEntity(
            id = domainModel.id,
            pkdxnumber = domainModel.pkdxnumber,
            pkmnname = domainModel.pkmnname,
            description = domainModel.description,
            url = domainModel.url
        )
    }

    fun mapFromEntityList(entities: List<PkmnNetworkEntity>): List<Pkmn>{
        return entities.map { mapFromEntity(it) }
    }
}