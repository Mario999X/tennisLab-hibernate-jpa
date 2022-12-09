package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import models.usuario.Trabajador
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */

@Entity
@Table(name = "tareas")
@NamedQueries(
    value = [
        NamedQuery(name = "Tarea.findAll", query = "select t from Tarea t")
    ]
)
data class Tarea(
    @Id
    val id: Long,
    @Expose val uuid: UUID = UUID.randomUUID(),

    @JoinColumn(name = "adquisicion_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose val adquisicion: Adquisicion? = null,

    @JoinColumn(name = "personalizar_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose val personalizar: Personalizar? = null,

    @JoinColumn(name = "encordar_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose val encordar: Encordar? = null,

    // TODO revisar el tema precio
    @Expose var precio: Double = 0.0,


    @JoinColumn(name = "trabajador_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose var trabajador: Trabajador,

    @ManyToOne()
    @JoinColumn(name = "pedido_id")
    var pedido: Pedido? = null
) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}