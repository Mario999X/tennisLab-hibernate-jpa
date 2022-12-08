package repository.adquisicion

import models.Adquisicion
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */
interface AdquisicionRepository : CrudRepository<Adquisicion, Long> {
}