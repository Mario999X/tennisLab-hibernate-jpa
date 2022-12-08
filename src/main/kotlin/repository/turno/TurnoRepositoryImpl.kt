package repository.turno

import database.HibernateManager
import models.Turno
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class TurnoRepositoryImpl : TurnoRepository{
    override fun findAll(): List<Turno> {
        log.debug { "findAll()" }
        var turnos = mutableListOf<Turno>()
        HibernateManager.query {
            val query: TypedQuery<Turno> = HibernateManager.manager.createNamedQuery("Turno.findAll", Turno::class.java)
            turnos = query.resultList
        }
        return turnos
    }

    override fun findById(id: Long): Turno? {
        log.debug { "findById($id)" }
        var turno: Turno? = null
        HibernateManager.query {
            turno = HibernateManager.manager.find(Turno::class.java, id)
        }
        return turno
    }

    override fun save(entity: Turno): Turno {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            HibernateManager.manager.merge(entity)
        }
        return entity
    }

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