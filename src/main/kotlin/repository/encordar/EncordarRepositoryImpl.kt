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

/**
 * EncordarRepositoryImpl, Clase que realiza operaciones CRUD, encordar.
 *
 */
class EncordarRepositoryImpl : EncordarRepository {
    /**
     * FindAll()
     *
     * @return Lista de encordados
     */
    override fun findAll(): List<Encordar> {
        log.debug { "findAll()" }
        var encordados = mutableListOf<Encordar>()
        HibernateManager.query {
            val query: TypedQuery<Encordar> = manager.createNamedQuery("Encordar.findAll", Encordar::class.java)
            encordados = query.resultList
        }
        return encordados
    }

    /**
     * FindById()
     *
     * @param id Identificador de encordar
     * @return Encordar o Null
     */
    override fun findById(id: Long): Encordar? {
        log.debug { "findById($id)" }
        var encordado: Encordar? = null
        HibernateManager.query {
            encordado = manager.find(Encordar::class.java, id)
        }
        return encordado
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Encordar
     * @return Encordar
     */
    override fun save(entity: Encordar): Encordar {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Encordar
     * @return Boolean
     */
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