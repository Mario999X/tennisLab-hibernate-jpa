package repository.usuario

import database.HibernateManager
import database.HibernateManager.manager
import models.usuario.Cliente
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * ClienteRepositoryImpl Clase que realiza operaciones CRUD, clientes.
 *
 */
class ClienteRepositoryImpl : ClienteRepository {
    /**
     * FindAll()
     *
     * @return Lista de clientes
     */
    override fun findAll(): List<Cliente> {
        log.debug { "findAll()" }
        var clientes = mutableListOf<Cliente>()
        HibernateManager.query {
            val query: TypedQuery<Cliente> = manager.createNamedQuery("Cliente.findAll", Cliente::class.java)
            clientes = query.resultList
        }
        return clientes
    }

    /**
     * FindById()
     *
     * @param id Identificador de Cliente
     * @return Cliente o Null
     */
    override fun findById(id: Long): Cliente? {
        log.debug { "findById($id)" }
        var cliente: Cliente? = null
        HibernateManager.query {
            cliente = manager.find(Cliente::class.java, id)
        }
        return cliente
    }

    /**
     * Save(), guarda o actualiza el entity
     *
     * @param entity Cliente
     * @return Cliente
     */
    override fun save(entity: Cliente): Cliente {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    /**
     * Delete(), se elimina el dato
     *
     * @param entity Cliente
     * @return Boolean.
     */
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