package models

import com.google.gson.GsonBuilder
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "encordados")
@NamedQueries(
    value = [
        NamedQuery(name = "Encordar.findAll", query = "select e from Encordar e")
    ]
)
class Encordar(
    @Id
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    val tensionCuerdasHorizontales: Double,
    val cordajeHorizontal: String,
    val tensionCuerdasVerticales: Double,
    val cordajeVertical: String,
    var nudos: Int,
    val precio: Double = 15.0
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}