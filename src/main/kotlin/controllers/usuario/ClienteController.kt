package controllers.usuario

import exceptions.GenericException
import models.usuario.Cliente
import mu.KotlinLogging
import repository.usuario.ClienteRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * ClienteController, clase que usa los metodos del respectivo repositorio.
 *
 * @property clienteRepository ClienteRepository
 */
class ClienteController(private val clienteRepository: ClienteRepository) {
    fun createCliente(cliente: Cliente): Cliente {
        log.debug { "Creando cliente $cliente" }
        clienteRepository.save(cliente)
        return cliente
    }

    fun getClientes(): List<Cliente> {
        log.debug { "Obteniendo clientes" }
        return clienteRepository.findAll()
    }

    fun getClienteById(id: Long): Cliente {
        log.debug { "Obteniendo cliente con id $id" }
        return clienteRepository.findById(id) ?: throw GenericException("Cliente con id $id no encontrado")
    }

    fun updateCliente(cliente: Cliente): Cliente {
        log.debug { "Actualizando $cliente" }
        return clienteRepository.save(cliente)
    }

    fun deleteCliente(it: Cliente): Boolean {
        log.debug { "Borrando cliente $it" }
        return if (clienteRepository.delete(it))
            true
        else
            throw GenericException("Cliente con id ${it.id} no encontrado")
    }
}