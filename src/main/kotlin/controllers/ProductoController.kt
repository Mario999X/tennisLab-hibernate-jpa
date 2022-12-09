package controllers

import exceptions.GenericException
import models.Producto
import mu.KotlinLogging
import repository.producto.ProductoRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * ProductoController, clase que usa los metodos del respectivo repositorio
 *
 * @property productoRepository ProductoRepository
 */
class ProductoController(private val productoRepository: ProductoRepository) {
    fun createProducto(producto: Producto): Producto {
        log.debug { "Creando producto $producto" }
        productoRepository.save(producto)
        return producto
    }

    fun getProductos(): List<Producto> {
        log.debug { "Obteniendo productos" }
        return productoRepository.findAll()
    }

    fun getProductoById(id: Long): Producto {
        log.debug { "Obteniendo producto con id $id" }
        return productoRepository.findById(id) ?: throw GenericException("Producto con id $id no encontrado")
    }

    fun updateProducto(producto: Producto): Producto {
        log.debug { "Actualizando $producto" }
        return productoRepository.save(producto)
    }

    fun deleteProducto(it: Producto): Boolean {
        log.debug { "Borrando producto $it" }
        return if (productoRepository.delete(it))
            true
        else
            throw GenericException("Producto con id ${it.id} no encontrado")
    }

}