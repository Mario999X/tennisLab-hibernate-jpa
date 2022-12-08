package repository.personalizadora

import models.maquina.Personalizadora
import repository.CrudRepository

interface PersonalizadoraRepository : CrudRepository<Personalizadora, Long> {
}