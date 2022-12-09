package controllers.usuario

import exceptions.GenericException
import models.usuario.Encargado
import mu.KotlinLogging
import repository.usuario.EncargadoRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * EncargadoController, clase que usa los metodos del respectivo repositorio.
 *
 * @property encargadoRepository EncargadoRepository
 */
class EncargadoController(private val encargadoRepository: EncargadoRepository) {
    fun createEncargado(encargado: Encargado): Encargado {
        log.debug { "Creando encargado $encargado" }
        encargadoRepository.save(encargado)
        return encargado
    }

    fun getEncargados(): List<Encargado> {
        log.debug { "Obteniendo encargados" }
        return encargadoRepository.findAll()
    }

    fun getEncargadoById(id: Long): Encargado {
        log.debug { "Obteniendo encargado con id $id" }
        return encargadoRepository.findById(id) ?: throw GenericException("Encargado con id $id no encontrado")
    }

    fun updateEncargado(encargado: Encargado): Encargado {
        log.debug { "Actualizando $encargado" }
        return encargadoRepository.save(encargado)
    }

    fun deleteEncargado(it: Encargado): Boolean {
        log.debug { "Borrando encargado $it" }
        return if (encargadoRepository.delete(it))
            true
        else
            throw GenericException("Encargado con id ${it.id} no encontrado")
    }
}