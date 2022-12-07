package controllers

import models.usuario.Trabajador
import mu.KotlinLogging
import repository.trabajador.TrabajadorRepository

private val log = KotlinLogging.logger { }

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

    fun getTrabajadorById(id: Long): Trabajador? {
        log.debug { "Obteniendo trabajador con id $id" }
        return trabajadorRepository.findById(id)
    }

    fun updateTrabajador(trabajador: Trabajador): Trabajador {
        log.debug { "Actualizando $trabajador" }
        return trabajadorRepository.save(trabajador)
    }

    fun deleteTrabajador(it: Trabajador): Boolean {
        log.debug { "Borrando trabajador $it" }
        return trabajadorRepository.delete(it)
    }
}