package controllers.maquina

import models.maquina.Encordadora
import mu.KotlinLogging
import repository.encordadora.EncordadoraRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

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

    fun getEncordadoraById(id: Long): Encordadora? {
        log.debug { "Obteniendo encordadora con id $id" }
        return encordadoraRepository.findById(id)
    }

    fun updateEncordadora(encordadora: Encordadora): Encordadora {
        log.debug { "Actualizando $encordadora" }
        return encordadoraRepository.save(encordadora)
    }

    fun deleteEncordadora(it: Encordadora): Boolean {
        log.debug { "Borrando $it" }
        return encordadoraRepository.delete(it)
    }
}