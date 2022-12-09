package controllers.usuario

import exceptions.GenericException
import models.usuario.Trabajador
import mu.KotlinLogging
import repository.usuario.TrabajadorRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * TrabajadorController, clase que usa los metodos del respectivo repositorio.
 *
 * @property trabajadorRepository TrabajadorRepository
 */
class TrabajadorController(private val trabajadorRepository: TrabajadorRepository) {
    fun createTrabajador(trabajador: Trabajador): Trabajador {
        log.debug { "Creando trabajador $trabajador" }
        trabajadorRepository.save(trabajador)
        return trabajador
    }

    fun getTrabajadores(): List<Trabajador> {
        log.debug { "Obteniendo trabajadores" }
        return trabajadorRepository.findAll()
    }

    fun getTrabajadorById(id: Long): Trabajador {
        log.debug { "Obteniendo trabajador con id $id" }
        return trabajadorRepository.findById(id) ?: throw GenericException("Trabajador con id $id no encontrado")
    }

    fun updateTrabajador(trabajador: Trabajador): Trabajador {
        log.debug { "Actualizando $trabajador" }
        return trabajadorRepository.save(trabajador)
    }

    fun deleteTrabajador(it: Trabajador): Boolean {
        log.debug { "Borrando trabajador $it" }
        return if (trabajadorRepository.delete(it))
            true
        else
            throw GenericException("Trabajador con id ${it.id} no encontrado")
    }
}