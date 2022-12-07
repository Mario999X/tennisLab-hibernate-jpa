package repository.producto

import database.HibernateManager
import database.HibernateManager.manager
import models.Producto
import mu.KotlinLogging
import javax.persistence.TypedQuery

private val log = KotlinLogging.logger { }

class ProductoRepositoryImpl : ProductoRepository {
    override fun findAll(): List<Producto> {
        log.debug { "findAll()" }
        var productos = mutableListOf<Producto>()
        HibernateManager.query {
            val query: TypedQuery<Producto> = manager.createNamedQuery("Producto.findAll", Producto::class.java)
            productos = query.resultList
        }
        return productos
    }

    override fun findById(id: Long): Producto? {
        log.debug { "findById($id)" }
        var producto: Producto? = null
        HibernateManager.query {
            producto = manager.find(Producto::class.java, id)
        }
        return producto
    }

    override fun save(entity: Producto): Producto {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Producto): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val producto = manager.find(Producto::class.java, entity.id)
            producto?.let {
                manager.remove(it)
                result = true
            }
        }
        return result
    }
}