package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */
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
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose var peso: Double,
    @Expose val balance: Double,
    @Expose val rigidez: Int,
    @Expose val precio: Double = 60.0,

    @OneToOne(fetch = FetchType.EAGER)
    val tarea: Tarea? = null
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}