package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */

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
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose val tipo: Tipo,
    @Expose val marca: String,
    @Expose val modelo: String,
    @Expose var stock: Int,
    @Expose val precio: Double
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
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}