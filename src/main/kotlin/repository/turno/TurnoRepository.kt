package repository.turno

import models.Turno
import repository.CrudRepository

interface TurnoRepository : CrudRepository<Turno, Long> {
}