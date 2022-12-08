package models

import com.google.gson.GsonBuilder
import models.usuario.Cliente
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */

@Entity
@Table(name = "raqueta")
@NamedQueries(
    value = [
        NamedQuery(name = "Raqueta.findAll", query = "select r from Raqueta r")
    ]
)
class Raqueta(
    @Id
    @Column(name = "id")
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    var marca: String,
    var modelo: String,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = true)
    var cliente: Cliente? = null
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}