package repository.adquisicion

import database.HibernateManager
import database.HibernateManager.manager
import models.Adquisicion
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class AdquisicionRepositoryImpl : AdquisicionRepository {
    override fun findAll(): List<Adquisicion> {
        log.debug { "findAll()" }
        var adquisiciones = mutableListOf<Adquisicion>()
        HibernateManager.query {
            val query: TypedQuery<Adquisicion> =
                manager.createNamedQuery("Adquisicion.FindAll", Adquisicion::class.java)
            adquisiciones = query.resultList
        }
        return adquisiciones
    }

    override fun findById(id: Long): Adquisicion? {
        log.debug { "findById($id)" }
        var adquisicion: Adquisicion? = null
        HibernateManager.query {
            adquisicion = manager.find(Adquisicion::class.java, id)
        }
        return adquisicion
    }

    override fun save(entity: Adquisicion): Adquisicion {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Adquisicion): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val adquisicion = manager.find(Adquisicion::class.java, entity.id)
            adquisicion?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }

}