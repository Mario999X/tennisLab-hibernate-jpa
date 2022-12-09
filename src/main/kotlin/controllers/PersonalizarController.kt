package controllers

import models.Personalizar
import mu.KotlinLogging
import repository.personalizar.PersonalizarRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }

/**
 * PersonalizarController, clase que usa los metodos del respectivo repositorio.
 *
 * @property personalizarRepository PersonalizarRepository
 */
class PersonalizarController(private val personalizarRepository: PersonalizarRepository) {
    fun createPersonalizacion(personalizar: Personalizar): Personalizar {
        log.debug { "Creando personalizacion $personalizar" }
        personalizarRepository.save(personalizar)
        return personalizar
    }

    fun getPersonalizaciones(): List<Personalizar> {
        log.debug { "Obteniendo personalizaciones" }
        return personalizarRepository.findAll()
    }

    fun getPersonalizacionById(id: Long): Personalizar? {
        log.debug { "Obteniendo personalizacion con id $id" }
        return personalizarRepository.findById(id)
    }

    fun updatePersonalizacion(personalizar: Personalizar): Personalizar {
        log.debug { "Actualizando $personalizar" }
        return personalizarRepository.save(personalizar)
    }

    fun deletePersonalizacion(it: Personalizar): Boolean {
        log.debug { "Borrando personalizacion $it" }
        return personalizarRepository.delete(it)
    }
}