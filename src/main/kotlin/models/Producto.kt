package models

import com.google.gson.GsonBuilder
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "productos")
@NamedQueries(
    value = [
        NamedQuery(name = "Producto.findAll", query = "select p from Producto p")
    ]
)
data class Producto(
    @Id
    val id: Long,
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "uuid")
    @Type(type = "uuid-char")
    val uuid: UUID = UUID.randomUUID(),
    val tipo: Tipo,
    val marca: String,
    val modelo: String,
    var stock: Int,
    val precio: Double
) {
    enum class Tipo(val item: String) {
        RAQUETA("RAQUETA"),
        CORDAJE("CORDAJE"),
        COMPLEMENTO("COMPLEMENTO");

        companion object {
            fun from(tipo: String): Tipo {
                return when (tipo.uppercase()) {
                    "RAQUETA" -> RAQUETA
                    "CORDAJE" -> CORDAJE
                    "COMPLEMENTO" -> COMPLEMENTO
                    else -> throw IllegalArgumentException("Tipo no reconocido")
                }
            }
        }
    }

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}