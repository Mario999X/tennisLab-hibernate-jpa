package controllers

import models.Pedido
import mu.KotlinLogging
import repository.pedido.PedidoRepository

private val log = KotlinLogging.logger { }

/**
 * PedidoController, clase que usa los metodos del respectivo repositorio.
 *
 * @property pedidoRepository PedidoRepository
 */
class PedidoController(private val pedidoRepository: PedidoRepository) {
    fun createPedido(pedido: Pedido): Pedido {
        log.debug { "Creando pedido $pedido" }
        pedidoRepository.save(pedido)
        return pedido
    }

    fun getPedidos(): List<Pedido> {
        log.debug { "Obteniendo pedidos" }
        return pedidoRepository.findAll()
    }

    fun getPedidoById(id: Long): Pedido? {
        log.debug { "Obteniendo pedido con id $id" }
        return pedidoRepository.findById(id)
    }

    fun updatePedido(pedido: Pedido): Pedido {
        log.debug { "Actualizando $pedido" }
        return pedidoRepository.save(pedido)
    }

    fun deletePedido(it: Pedido): Boolean {
        log.debug { "Borrando pedido $it" }
        return pedidoRepository.delete(it)
    }
}