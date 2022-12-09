package repository.turno

import database.HibernateManager
import models.Turno
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */
private val log = KotlinLogging.logger { }

/**
 * TurnoRepositoryImpl, Clase que realiza operaciones CRUD, turnos.
 *
 */
class TurnoRepositoryImpl : TurnoRepository{
    /**
     * FindAll()
     *
     * @return Lista de turnos
     */
    override fun findAll(): List<Turno> {
        log.debug { "findAll()" }
        var turnos = mutableListOf<Turno>()
        HibernateManager.query {
            val query: TypedQuery<Turno> = HibernateManager.manager.createNamedQuery("Turno.findAll", Turno::class.java)
            turnos = query.resultList
        }
        return turnos
    }

    /**
     * FindById()
     *
     * @param id Identificador de turno
     * @return Turno o Null
     */
    override fun findById(id: Long): Turno? {
        log.debug { "findById($id)" }
        var turno: Turno? = null
        HibernateManager.query {
            turno = HibernateManager.manager.find(Turno::class.java, id)
        }
        return turno
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Turno
     */
    override fun save(entity: Turno): Turno {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            HibernateManager.manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Turno
     * @return Boolean
     */
    override fun delete(entity: Turno): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val turno = HibernateManager.manager.find(Turno::class.java, entity.id)
            turno?.let {
                HibernateManager.manager.remove(it)
                result = true
            }
        }
        return result
    }
}