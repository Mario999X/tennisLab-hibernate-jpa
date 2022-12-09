package repository.usuario

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Encargado
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * EncargadoRepositoryImpl Clase que realiza operaciones CRUD, encargados.
 *
 */
class EncargadoRepositoryImpl : EncargadoRepository {
    /**
     * FindAll()
     *
     * @return Lista de encargados
     */
    override fun findAll(): List<Encargado> {
        log.debug { "findAll()" }
        var encargados = mutableListOf<Encargado>()
        HibernateManager.query {
            val query: TypedQuery<Encargado> = manager.createNamedQuery("Encargado.findAll", Encargado::class.java)
            encargados = query.resultList
        }
        return encargados
    }

    /**
     * FindById()
     *
     * @param id Identificador de encargado
     * @return Encargado o Null
     */
    override fun findById(id: Long): Encargado? {
        log.debug { "findById($id)" }
        var encargado: Encargado? = null
        HibernateManager.query {
            encargado = manager.find(Encargado::class.java, id)
        }
        return encargado
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Encargado
     * @return Encargado
     */
    override fun save(entity: Encargado): Encargado {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Encargado
     * @return Boolean
     */
    override fun delete(entity: Encargado): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val encargado = manager.find(Encargado::class.java, entity.id)
            encargado?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}