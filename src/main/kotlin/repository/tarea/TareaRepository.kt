package repository.tarea

import models.Tarea
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

interface TareaRepository : CrudRepository<Tarea, Long>{
}