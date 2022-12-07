package models

import com.google.gson.GsonBuilder
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "adquisiciones")
@NamedQueries(
    value = [
        NamedQuery(name = "Adquisicion.FindAll", query = "select a from Adquisicion a")
    ]
)
data class Adquisicion(
    @Id
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    var cantidad: Int,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "producto_id")
    var producto: Producto? = null,
    var precio: Double? = producto?.precio?.times(cantidad)
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}