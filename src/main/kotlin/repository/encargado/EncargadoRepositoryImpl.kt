package repository.encargado

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Encargado
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class EncargadoRepositoryImpl : EncargadoRepository {
    override fun findAll(): List<Encargado> {
        log.debug { "findAll()" }
        var encargados = mutableListOf<Encargado>()
        HibernateManager.query {
            val query: TypedQuery<Encargado> = manager.createNamedQuery("Encargado.findAll", Encargado::class.java)
            encargados = query.resultList
        }
        return encargados
    }

    override fun findById(id: Long): Encargado? {
        log.debug { "findById($id)" }
        var encargado: Encargado? = null
        HibernateManager.query {
            encargado = manager.find(Encargado::class.java, id)
        }
        return encargado
    }

    override fun save(entity: Encargado): Encargado {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

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