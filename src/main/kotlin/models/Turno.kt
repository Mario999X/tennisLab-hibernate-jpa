package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import models.maquina.Encordadora
import models.maquina.Personalizadora
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "turnos")
@NamedQueries(
    value = [
        NamedQuery(name = "Turno.findAll", query = "select t from Turno t")
    ]
)
data class Turno(
    @Id
    val id: Long,
    @Expose val uuid: UUID = UUID.randomUUID(),
    @Expose var horario: TipoHorario,

    @JoinColumn(name = "encordadora_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose var encordadora: Encordadora? = null,

    @JoinColumn(name = "personalizadora_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose var personalizadora: Personalizadora? = null

    // TODO TRABAJADOR no nulo, falta
) {

    enum class TipoHorario(val horario: String) {
        TEMPRANO("MAÑANA"),
        TARDE("TARDE");

        companion object {
            fun from(tipoHorario: String): TipoHorario {
                return when (tipoHorario.uppercase()) {
                    "MAÑANA" -> TEMPRANO
                    "TARDE" -> TARDE
                    else -> throw IllegalArgumentException("Turno no reconocido")
                }
            }
        }
    }

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}