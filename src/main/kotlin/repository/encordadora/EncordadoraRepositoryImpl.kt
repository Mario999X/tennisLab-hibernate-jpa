package repository.encordadora

import database.HibernateManager
import models.maquina.Encordadora
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * EncordadoraRepositoryImpl, Clase que realiza operaciones CRUD, encordadoras.
 *
 */
class EncordadoraRepositoryImpl : EncordadoraRepository {
    /**
     * FindAll()
     *
     * @return Lista de encordadoras
     */
    override fun findAll(): List<Encordadora> {
        log.debug { "findAll()" }
        var encordadoras = mutableListOf<Encordadora>()
        HibernateManager.query {
            val query: TypedQuery<Encordadora> = HibernateManager.manager.createNamedQuery("Encordadora.findAll", Encordadora::class.java)
            encordadoras = query.resultList
        }
        return encordadoras
    }

    /**
     * FindById()
     *
     * @param id Identificador de encordadora
     * @return Encordadora o Null
     */
    override fun findById(id: Long): Encordadora? {
        log.debug { "findById($id)" }
        var encordadora: Encordadora? = null
        HibernateManager.query {
            encordadora = HibernateManager.manager.find(Encordadora::class.java, id)
        }
        return encordadora
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Encordadora
     */
    override fun save(entity: Encordadora): Encordadora {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            HibernateManager.manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Encordadora
     * @return Boolean
     */
    override fun delete(entity: Encordadora): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val encordadora = HibernateManager.manager.find(Encordadora::class.java, entity.id)
            encordadora?.let {
                HibernateManager.manager.remove(it)
                result = true
            }
        }
        return result
    }
}