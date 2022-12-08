package repository.cliente

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Cliente
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

class ClienteRepositoryImpl : ClienteRepository {
    override fun findAll(): List<Cliente> {
        log.debug { "findAll()" }
        var clientes = mutableListOf<Cliente>()
        HibernateManager.query {
            val query: TypedQuery<Cliente> = manager.createNamedQuery("Cliente.findAll", Cliente::class.java)
            clientes = query.resultList
        }
        return clientes
    }

    override fun findById(id: Long): Cliente? {
        log.debug { "findById($id)" }
        var cliente: Cliente? = null
        HibernateManager.query {
            cliente = manager.find(Cliente::class.java, id)
        }
        return cliente
    }

    override fun save(entity: Cliente): Cliente {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Cliente): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val cliente = manager.find(Cliente::class.java, entity.id)
            cliente?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}