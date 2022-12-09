package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */
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
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose var cantidad: Int,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "producto_id")
    @Expose var producto: Producto? = null,
    @Expose var precio: Double? = producto?.precio?.times(cantidad),

    @OneToOne(fetch = FetchType.EAGER)
    var tarea: Tarea? = null
) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}