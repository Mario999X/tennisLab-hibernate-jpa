package repository.encordadora

import models.maquina.Encordadora
import repository.CrudRepository

interface EncordadoraRepository : CrudRepository<Encordadora, Long> {
}