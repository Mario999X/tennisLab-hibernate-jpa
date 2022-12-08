package repository.pedido

import database.HibernateManager
import database.HibernateManager.manager
import models.Pedido
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class PedidoRepositoryImpl : PedidoRepository {
    override fun findAll(): List<Pedido> {
        log.debug { "findAll()" }
        var pedidos = mutableListOf<Pedido>()
        HibernateManager.query {
            val query: TypedQuery<Pedido> = manager.createNamedQuery("Pedido.findAll", Pedido::class.java)
            pedidos = query.resultList
        }
        return pedidos
    }

    override fun findById(id: Long): Pedido? {
        log.debug { "findById($id)" }
        var pedido: Pedido? = null
        HibernateManager.query {
            pedido = manager.find(Pedido::class.java, id)
        }
        return pedido
    }

    override fun save(entity: Pedido): Pedido {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Pedido): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val pedido = manager.find(Pedido::class.java, entity.id)
            pedido?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}