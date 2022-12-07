package repository.personalizar

import models.Personalizar
import repository.CrudRepository

interface PersonalizarRepository : CrudRepository<Personalizar, Long> {
}