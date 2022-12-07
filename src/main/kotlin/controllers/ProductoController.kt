package controllers

import models.Producto
import mu.KotlinLogging
import repository.producto.ProductoRepository

private val log = KotlinLogging.logger { }

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

    fun getProductoById(id: Long): Producto? {
        log.debug { "Obteniendo producto con id $id" }
        return productoRepository.findById(id)
    }

    fun updateProducto(producto: Producto): Producto {
        log.debug { "Actualizando $producto" }
        return productoRepository.save(producto)
    }

    fun deleteProducto(it: Producto): Boolean {
        log.debug { "Borrando producto $it" }
        return productoRepository.delete(it)
    }

}