package repository.encordar

import database.HibernateManager
import database.HibernateManager.manager
import models.Encordar
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

class EncordarRepositoryImpl : EncordarRepository {
    override fun findAll(): List<Encordar> {
        log.debug { "findAll()" }
        var encordados = mutableListOf<Encordar>()
        HibernateManager.query {
            val query: TypedQuery<Encordar> = manager.createNamedQuery("Encordar.findAll", Encordar::class.java)
            encordados = query.resultList
        }
        return encordados
    }

    override fun findById(id: Long): Encordar? {
        log.debug { "findById($id)" }
        var encordado: Encordar? = null
        HibernateManager.query {
            encordado = manager.find(Encordar::class.java, id)
        }
        return encordado
    }

    override fun save(entity: Encordar): Encordar {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Encordar): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val encordar = manager.find(Encordar::class.java, entity.id)
            encordar?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}