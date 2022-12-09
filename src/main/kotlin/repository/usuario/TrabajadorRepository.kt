package repository.usuario

import models.usuario.Trabajador
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */
interface TrabajadorRepository : CrudRepository<Trabajador, Long> {
}