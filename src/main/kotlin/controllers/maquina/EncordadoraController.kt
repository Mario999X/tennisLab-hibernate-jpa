package controllers.maquina

import exceptions.GenericException
import models.maquina.Encordadora
import mu.KotlinLogging
import repository.encordadora.EncordadoraRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * EncordadoraController, clase que usa los metodos del respectivo repositorio.
 *
 * @property encordadoraRepository EncordadoraRepository
 */
class EncordadoraController(private val encordadoraRepository: EncordadoraRepository) {
    fun createEncordadora(encordadora: Encordadora): Encordadora {
        log.debug { "Creando $encordadora" }
        encordadoraRepository.save(encordadora)
        return encordadora
    }

    fun getEncordadoras(): List<Encordadora> {
        log.debug { "Obteniendo encordadoras" }
        return encordadoraRepository.findAll()
    }

    fun getEncordadoraById(id: Long): Encordadora {
        log.debug { "Obteniendo encordadora con id $id" }
        return encordadoraRepository.findById(id) ?: throw GenericException("Encordadora con id $id no encontrada")
    }

    fun updateEncordadora(encordadora: Encordadora): Encordadora {
        log.debug { "Actualizando $encordadora" }
        return encordadoraRepository.save(encordadora)
    }

    fun deleteEncordadora(it: Encordadora): Boolean {
        log.debug { "Borrando $it" }
        return if (encordadoraRepository.delete(it))
            true
        else
            throw GenericException("Encordadora con id ${it.id} no encontrada")
    }
}