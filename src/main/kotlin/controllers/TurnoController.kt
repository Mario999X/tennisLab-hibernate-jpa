package controllers

import exceptions.GenericException
import models.Turno
import mu.KotlinLogging
import repository.turno.TurnoRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * TurnoController, clase que usa los metodos del respectivo repositorio
 *
 * @property turnoRepository TurnoRepository
 */
class TurnoController(private val turnoRepository: TurnoRepository) {

    fun createTurno(turno: Turno): Turno {
        log.debug { "Creando $turno" }
        turnoRepository.save(turno)
        return turno
    }

    fun getTurnos(): List<Turno> {
        log.debug { "Obteniendo turnos" }
        return turnoRepository.findAll()
    }

    fun getTurnoById(id: Long): Turno {
        log.debug { "Obteniendo turno con id $id" }
        return turnoRepository.findById(id) ?: throw GenericException("Turno con id $id no encontrado")
    }

    fun updateTurno(turno: Turno): Turno {
        log.debug { "Actualizando $turno" }
        return turnoRepository.save(turno)
    }

    fun deleteTurno(it: Turno): Boolean {
        log.debug { "Borrando turno $it" }
        return if (turnoRepository.delete(it))
            true
        else
            throw GenericException("Turno con id ${it.id} no encontrado")
    }
}