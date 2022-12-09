package repository.adquisicion

import database.HibernateManager
import database.HibernateManager.manager
import models.Adquisicion
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * AdquisicionRepositoryImpl, Clase que realiza operaciones CRUD, adquisiciones.
 *
 */
class AdquisicionRepositoryImpl : AdquisicionRepository {
    /**
     * FindAll()
     *
     * @return Lista de adquisiciones
     */
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

    /**
     * FindById()
     *
     * @param id Identificador de adquisicion
     * @return Adquisicion o Null
     */
    override fun findById(id: Long): Adquisicion? {
        log.debug { "findById($id)" }
        var adquisicion: Adquisicion? = null
        HibernateManager.query {
            adquisicion = manager.find(Adquisicion::class.java, id)
        }
        return adquisicion
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Adquisicion
     * @return Adquisicion
     */
    override fun save(entity: Adquisicion): Adquisicion {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Adquisicion
     * @return Boolean
     */
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