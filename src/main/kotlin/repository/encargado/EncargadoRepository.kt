package repository.encargado

import models.usuario.Encargado
import repository.CrudRepository

interface EncargadoRepository : CrudRepository<Encargado, Long> {
}