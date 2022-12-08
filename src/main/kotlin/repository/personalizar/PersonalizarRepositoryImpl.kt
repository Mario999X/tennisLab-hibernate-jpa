package repository.personalizar

import database.HibernateManager
import database.HibernateManager.manager
import models.Personalizar
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

class PersonalizarRepositoryImpl : PersonalizarRepository {
    override fun findAll(): List<Personalizar> {
        log.debug { "findAll()" }
        var personalizaciones = mutableListOf<Personalizar>()
        HibernateManager.query {
            val query: TypedQuery<Personalizar> =
                manager.createNamedQuery("Personalizar.findAll", Personalizar::class.java)
            personalizaciones = query.resultList
        }
        return personalizaciones
    }

    override fun findById(id: Long): Personalizar? {
        log.debug { "findById($id)" }
        var personalizacion: Personalizar? = null
        HibernateManager.query {
            personalizacion = manager.find(Personalizar::class.java, id)
        }
        return personalizacion
    }

    override fun save(entity: Personalizar): Personalizar {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Personalizar): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val personalizacion = manager.find(Personalizar::class.java, entity.id)
            personalizacion?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}