package controllers

import exceptions.GenericException
import models.Encordar
import mu.KotlinLogging
import repository.encordar.EncordarRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * EncordarController, clase que usa los metodos del respectivo repositorio.
 *
 * @property encordarRepository EncordarRepository
 */
class EncordarController(private val encordarRepository: EncordarRepository) {
    fun createEncordado(encordar: Encordar): Encordar {
        log.debug { "Creando encordado $encordar" }
        encordarRepository.save(encordar)
        return encordar
    }

    fun getEncordados(): List<Encordar> {
        log.debug { "Obteniendo encordados" }
        return encordarRepository.findAll()
    }

    fun getEncordadoById(id: Long): Encordar {
        log.debug { "Obteniendo encordado con id $id" }
        return encordarRepository.findById(id) ?: throw GenericException("Encordado con id $id no encontrado")
    }

    fun updateEncordado(encordar: Encordar): Encordar {
        log.debug { "Actualizando $encordar" }
        return encordarRepository.save(encordar)
    }

    fun deleteEncordado(it: Encordar): Boolean {
        log.debug { "Borrando encordado $it" }
        return if (encordarRepository.delete(it))
            true
        else
            throw GenericException("Encordado con id ${it.id} no encontrado")
    }
}