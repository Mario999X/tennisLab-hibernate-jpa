package repository.cliente

import models.usuario.Cliente
import repository.CrudRepository

interface ClienteRepository : CrudRepository<Cliente, Long> {
}