package controllers

import models.Encordar
import mu.KotlinLogging
import repository.encordar.EncordarRepository

private val log = KotlinLogging.logger { }

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

    fun getEncordadoById(id: Long): Encordar? {
        log.debug { "Obteniendo encordado con id $id" }
        return encordarRepository.findById(id)
    }

    fun updateEncordado(encordar: Encordar): Encordar {
        log.debug { "Actualizando $encordar" }
        return encordarRepository.save(encordar)
    }

    fun deleteEncordado(it: Encordar): Boolean {
        log.debug { "Borrando encordado $it" }
        return encordarRepository.delete(it)
    }
}