package repository.encordar

import models.Encordar
import repository.CrudRepository

interface EncordarRepository : CrudRepository<Encordar, Long> {
}