package repository.usuario

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Trabajador
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

/**
 * @author Sebastian Mendoza y Mario Resa
 */
class TrabajadorRepositoryImpl : TrabajadorRepository {
    override fun findAll(): List<Trabajador> {
        log.debug { "findAll()" }
        var trabajadores = mutableListOf<Trabajador>()
        HibernateManager.query {
            val query: TypedQuery<Trabajador> = manager.createNamedQuery("Trabajador.findAll", Trabajador::class.java)
            trabajadores = query.resultList
        }
        return trabajadores
    }

    override fun findById(id: Long): Trabajador? {
        log.debug { "findById($id)" }
        var trabajador: Trabajador? = null
        HibernateManager.query {
            trabajador = manager.find(Trabajador::class.java, id)
        }
        return trabajador
    }

    override fun save(entity: Trabajador): Trabajador {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

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