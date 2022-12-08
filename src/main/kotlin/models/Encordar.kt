package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */
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
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose val tensionCuerdasHorizontales: Double,
    @Expose val cordajeHorizontal: String,
    @Expose val tensionCuerdasVerticales: Double,
    @Expose val cordajeVertical: String,
    @Expose var nudos: Int,
    @Expose val precio: Double = 15.0,

    @OneToOne(fetch = FetchType.EAGER)
    val tarea: Tarea? = null
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}