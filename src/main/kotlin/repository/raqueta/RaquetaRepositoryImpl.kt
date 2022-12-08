package repository.raqueta

import database.HibernateManager
import database.HibernateManager.manager
import models.Raqueta
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class RaquetaRepositoryImpl : RaquetaRepository {
    override fun findAll(): List<Raqueta> {
        log.debug { "findAll()" }
        var raquetas = mutableListOf<Raqueta>()
        HibernateManager.query {
            val query: TypedQuery<Raqueta> = manager.createNamedQuery("Raqueta.findAll", Raqueta::class.java)
            raquetas = query.resultList
        }
        return raquetas
    }

    override fun findById(id: Long): Raqueta? {
        log.debug { "findById($id)" }
        var raqueta: Raqueta? = null
        HibernateManager.query {
            raqueta = manager.find(Raqueta::class.java, id)
        }
        return raqueta
    }

    override fun save(entity: Raqueta): Raqueta {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Raqueta): Boolean {
        var result = false
        log.debug { "delete($entity))" }
        HibernateManager.transaction {
            val raqueta = manager.find(Raqueta::class.java, entity.id)
            raqueta?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}