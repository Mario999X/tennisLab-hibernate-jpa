package repository.producto

import models.Producto
import repository.CrudRepository

interface ProductoRepository : CrudRepository<Producto, Long> {
}