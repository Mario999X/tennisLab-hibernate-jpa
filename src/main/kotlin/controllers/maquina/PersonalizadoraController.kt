package controllers.maquina

import models.maquina.Personalizadora
import mu.KotlinLogging
import repository.personalizadora.PersonalizadoraRepository

private val log = KotlinLogging.logger { }

class PersonalizadoraController(private val personalizadoraRepository: PersonalizadoraRepository) {

    fun createPersonalizadora(personalizadora: Personalizadora): Personalizadora {
        log.debug { "Creando $personalizadora" }
        personalizadoraRepository.save(personalizadora)
        return personalizadora
    }

    fun getPersonalizadoras(): List<Personalizadora> {
        log.debug { "Obteniendo personalizadoras" }
        return personalizadoraRepository.findAll()
    }

    fun getPersonalizadoraById(id: Long): Personalizadora? {
        log.debug { "Obteniendo personalizadora con id $id" }
        return personalizadoraRepository.findById(id)
    }

    fun updatePersonalizadora(personalizadora: Personalizadora): Personalizadora {
        log.debug { "Actualizando $personalizadora" }
        return personalizadoraRepository.save(personalizadora)
    }

    fun deletePersonalizadora(it: Personalizadora): Boolean {
        log.debug { "Borrando $it" }
        return personalizadoraRepository.delete(it)
    }
}