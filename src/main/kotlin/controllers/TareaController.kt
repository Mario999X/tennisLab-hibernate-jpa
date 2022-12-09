package controllers

import exceptions.GenericException
import models.Tarea
import mu.KotlinLogging
import repository.tarea.TareaRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * TareaController, clase que usa los metodos del respectivo repositorio
 *
 * @property tareaRepository TareaRepository
 */
class TareaController(private val tareaRepository: TareaRepository) {

    fun createTarea(tarea: Tarea): Tarea {
        log.debug { "Creando $tarea" }
        tareaRepository.save(tarea)
        return tarea
    }

    fun getTareas(): List<Tarea> {
        log.debug { "Obteniendo tareas" }
        return tareaRepository.findAll()
    }

    fun getTareaById(id: Long): Tarea {
        log.debug { "Obteniendo tarea con id $id" }
        return tareaRepository.findById(id) ?: throw GenericException("Tarea con id $id no encontrada")
    }

    fun updateTarea(tarea: Tarea): Tarea {
        log.debug { "Actualizando $tarea" }
        return tareaRepository.save(tarea)
    }

    fun deleteTarea(it: Tarea): Boolean {
        log.debug { "Borrando $it" }
        return if (tareaRepository.delete(it))
            true
        else
            throw GenericException("Tarea con id ${it.id} no encontrado")
    }
}