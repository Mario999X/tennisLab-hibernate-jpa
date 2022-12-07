package repository.trabajador

import models.usuario.Trabajador
import repository.CrudRepository

interface TrabajadorRepository : CrudRepository<Trabajador, Long> {
}