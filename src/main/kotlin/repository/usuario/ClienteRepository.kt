package repository.usuario

import models.usuario.Cliente
import repository.CrudRepository

/**
 * @author Sebastian Mendoza y Mario Resa
 */
interface ClienteRepository : CrudRepository<Cliente, Long> {
}