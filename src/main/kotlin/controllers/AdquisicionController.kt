package controllers

import models.Adquisicion
import mu.KotlinLogging
import repository.adquisicion.AdquisicionRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

class AdquisicionController(private val adquisicionRepository: AdquisicionRepository) {
    fun createAdqusicion(adquisicion: Adquisicion): Adquisicion {
        log.info("Creando adquisicion $adquisicion")
        adquisicionRepository.save(adquisicion)
        return adquisicion
    }

    fun getAdquisiciones(): List<Adquisicion> {
        log.info("Obteniendo Adquisiciones")
        return adquisicionRepository.findAll()
    }

    fun getAdquisicionById(id: Long): Adquisicion? {
        log.debug { "Obteniendo adquisicion con id $id" }
        return adquisicionRepository.findById(id)
    }

    fun updateAdquisicion(adquisicion: Adquisicion): Adquisicion {
        log.debug { "Actualizando $adquisicion" }
        return adquisicionRepository.save(adquisicion)
    }

    fun deleteAdquisicion(it: Adquisicion): Boolean {
        log.debug { "Borrando adquisicion $it" }
        return adquisicionRepository.delete(it)
    }
}