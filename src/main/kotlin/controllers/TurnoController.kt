package controllers

import models.Turno
import mu.KotlinLogging
import repository.turno.TurnoRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

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

    fun getTurnoById(id: Long): Turno? {
        log.debug { "Obteniendo turno con id $id" }
        return turnoRepository.findById(id)
    }

    fun updateTurno(turno: Turno): Turno {
        log.debug { "Actualizando $turno" }
        return turnoRepository.save(turno)
    }

    fun deleteTurno(it: Turno): Boolean {
        log.debug { "Borrando turno $it" }
        return turnoRepository.delete(it)
    }
}