package repository.usuario

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Trabajador
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */
private val log = KotlinLogging.logger { }


/**
 * TrabajadorRepositoryImpl, Clase que realiza operaciones CRUD, trabajador.
 *
 */
class TrabajadorRepositoryImpl : TrabajadorRepository {
    /**
     * FindAll()
     *
     * @return Lista de trabajadores
     */
    override fun findAll(): List<Trabajador> {
        log.debug { "findAll()" }
        var trabajadores = mutableListOf<Trabajador>()
        HibernateManager.query {
            val query: TypedQuery<Trabajador> = manager.createNamedQuery("Trabajador.findAll", Trabajador::class.java)
            trabajadores = query.resultList
        }
        return trabajadores
    }

    /**
     * FindById()
     *
     * @param id Identificador de trabajador
     * @return Trabajador o Null
     */
    override fun findById(id: Long): Trabajador? {
        log.debug { "findById($id)" }
        var trabajador: Trabajador? = null
        HibernateManager.query {
            trabajador = manager.find(Trabajador::class.java, id)
        }
        return trabajador
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Trabajador
     * @return Trabajador
     */
    override fun save(entity: Trabajador): Trabajador {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Trabajador
     * @return Boolean
     */
    override fun delete(entity: Trabajador): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val trabajador = manager.find(Trabajador::class.java, entity.id)
            trabajador?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}