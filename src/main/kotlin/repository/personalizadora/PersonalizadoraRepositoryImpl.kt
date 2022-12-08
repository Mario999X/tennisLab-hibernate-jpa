package repository.personalizadora

import database.HibernateManager
import models.maquina.Personalizadora
import mu.KotlinLogging
import javax.persistence.TypedQuery

/**
 * @author Sebastian Mendoza y Mario Resa
 */

private val log = KotlinLogging.logger { }


class PersonalizadoraRepositoryImpl : PersonalizadoraRepository {
    override fun findAll(): List<Personalizadora> {
        log.debug { "findAll()" }
        var personalizadoras = mutableListOf<Personalizadora>()
        HibernateManager.query {
            val query: TypedQuery<Personalizadora> =
                HibernateManager.manager.createNamedQuery("Personalizadora.findAll", Personalizadora::class.java)
            personalizadoras = query.resultList
        }
        return personalizadoras
    }

    override fun findById(id: Long): Personalizadora? {
        log.debug { "findById($id)" }
        var personalizadora: Personalizadora? = null
        HibernateManager.query {
            personalizadora = HibernateManager.manager.find(Personalizadora::class.java, id)
        }
        return personalizadora
    }

    override fun save(entity: Personalizadora): Personalizadora {
        log.debug { "save($entity)" }
        HibernateManager.transaction {
            HibernateManager.manager.merge(entity)
        }
        return entity
    }

    override fun delete(entity: Personalizadora): Boolean {
        var result = false
        log.debug { "delete($entity)" }
        HibernateManager.transaction {
            val personalizadora = HibernateManager.manager.find(Personalizadora::class.java, entity.id)
            personalizadora?.let {
                HibernateManager.manager.remove(it)
                result = true
            }
        }
        return result
    }
}