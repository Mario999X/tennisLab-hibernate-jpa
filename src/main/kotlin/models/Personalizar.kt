package models

import com.google.gson.GsonBuilder
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "personalizaciones")
@NamedQueries(
    value = [
        NamedQuery(name = "Personalizar.findAll", query = "select p from Personalizar p")
    ]
)
class Personalizar(
    @Id
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    var peso: Double,
    val balance: Double,
    val rigidez: Int,
    val precio: Double = 60.0
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}