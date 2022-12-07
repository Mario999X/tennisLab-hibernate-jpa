package repository.adquisicion

import models.Adquisicion
import repository.CrudRepository

interface AdquisicionRepository : CrudRepository<Adquisicion, Long> {
}