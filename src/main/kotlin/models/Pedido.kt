package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import models.usuario.Cliente
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "pedido")
@NamedQueries(
    value = [
        NamedQuery(name = "Pedido.findAll", query = "select p from Pedido p")
    ]
)
class Pedido(
    @Id
    val id: Long,
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose var estado: TipoEstado,
    @Expose var fechaEntrada: String,
    @Expose var fechaProgramada: String,
    @Expose var fechaSalida: String,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    var cliente: Cliente? = null,

    @OneToOne(fetch = FetchType.EAGER)
    val tarea: Tarea? = null
) {
    enum class TipoEstado(val estado: String) {
        RECIBIDO("RECIBIDO"),
        PROCESANDO("PROCESANDO"),
        TERMINADO("TERMINADO");

        companion object {
            fun from(estado: String): TipoEstado {
                return when (estado.uppercase()) {
                    "RECIBIDO" -> RECIBIDO
                    "PROCESANDO" -> PROCESANDO
                    "TERMINADO" -> TERMINADO
                    else -> throw IllegalArgumentException("Estado no reconocido")
                }
            }
        }
    }

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }

}