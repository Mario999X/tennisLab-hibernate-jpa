package repository.producto

import models.Producto
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */

interface ProductoRepository : CrudRepository<Producto, Long> {
}