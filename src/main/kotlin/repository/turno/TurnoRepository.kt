package repository.turno

import models.Turno
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */
interface TurnoRepository : CrudRepository<Turno, Long> {
}