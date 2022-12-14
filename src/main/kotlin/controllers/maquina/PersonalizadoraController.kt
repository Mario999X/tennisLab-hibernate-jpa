package controllers.maquina

import exceptions.GenericException
import models.maquina.Personalizadora
import mu.KotlinLogging
import repository.personalizadora.PersonalizadoraRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * PersonalizadoraController, clase que usa los metodos del respectivo repositorio.
 *
 * @property personalizadoraRepository PersonalizadoraRepository
 */
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

    fun getPersonalizadoraById(id: Long): Personalizadora {
        log.debug { "Obteniendo personalizadora con id $id" }
        return personalizadoraRepository.findById(id)
            ?: throw GenericException("Personalizadora con id $id no encontrada")
    }

    fun updatePersonalizadora(personalizadora: Personalizadora): Personalizadora {
        log.debug { "Actualizando $personalizadora" }
        return personalizadoraRepository.save(personalizadora)
    }

    fun deletePersonalizadora(it: Personalizadora): Boolean {
        log.debug { "Borrando $it" }
        return if (personalizadoraRepository.delete(it))
            true
        else
            throw GenericException("Personalizadora con id ${it.id} no encontrada")
    }
}