package repository.pedido

import models.Pedido
import repository.CrudRepository

interface PedidoRepository : CrudRepository<Pedido, Long> {
}