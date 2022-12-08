package models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import models.maquina.Encordadora
import models.maquina.Personalizadora
import models.usuario.Trabajador
import java.util.*
import javax.persistence.*
/**
 * @author Sebastian Mendoza y Mario Resa
 */

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
    @Expose var personalizadora: Personalizadora? = null,

    @JoinColumn(name = "trabajador_id")
    @OneToOne(fetch = FetchType.EAGER)
    @Expose var trabajador: Trabajador
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