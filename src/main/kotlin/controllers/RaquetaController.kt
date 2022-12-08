package controllers

import models.Raqueta
import mu.KotlinLogging
import repository.raqueta.RaquetaRepository

private val log = KotlinLogging.logger { }

class RaquetaController(private val raquetaRepository: RaquetaRepository) {
    fun createRaqueta(raqueta: Raqueta): Raqueta {
        log.debug { "Creando raqueta $raqueta" }
        raquetaRepository.save(raqueta)
        return raqueta
    }

    fun getRaquetas(): List<Raqueta> {
        log.debug { "Obteniendo raquetas" }
        return raquetaRepository.findAll()
    }

    fun getRaquetaById(id: Long): Raqueta? {
        log.debug { "Obteniendo raqueta con id $id" }
        return raquetaRepository.findById(id)
    }

    fun updateRaqueta(raqueta: Raqueta): Raqueta {
        log.debug { "Actualizando $raqueta" }
        return raquetaRepository.save(raqueta)
    }

    fun deleteRaqueta(it: Raqueta): Boolean {
        log.debug { "Borrando raqueta $it" }
        return raquetaRepository.delete(it)
    }
}