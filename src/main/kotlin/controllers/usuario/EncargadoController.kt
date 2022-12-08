package controllers.usuario

import models.usuario.Encargado
import mu.KotlinLogging
import repository.encargado.EncargadoRepository

private val log = KotlinLogging.logger { }

class EncargadoController(private val encargadoRepository: EncargadoRepository) {
    fun createEncargado(encargado: Encargado): Encargado {
        log.debug { "Creando encargado $encargado" }
        encargadoRepository.save(encargado)
        return encargado
    }

    fun getEncargados(): List<Encargado> {
        log.debug { "Obteniendo encargados" }
        return encargadoRepository.findAll()
    }

    fun getEncargadoById(id: Long): Encargado? {
        log.debug { "Obteniendo encargado con id $id" }
        return encargadoRepository.findById(id)
    }

    fun updateEncargado(encargado: Encargado): Encargado {
        log.debug { "Actualizando $encargado" }
        return encargadoRepository.save(encargado)
    }

    fun deleteEncargado(it: Encargado): Boolean {
        log.debug { "Borrando encargado $it" }
        return encargadoRepository.delete(it)
    }
}