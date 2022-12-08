package repository.raqueta

import models.Raqueta
import repository.CrudRepository

interface RaquetaRepository : CrudRepository<Raqueta, Long> {
}