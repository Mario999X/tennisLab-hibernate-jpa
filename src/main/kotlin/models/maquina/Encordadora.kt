package models.maquina

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import models.Turno
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */
@Entity
@Table(name = "encordadoras")
@NamedQueries(
    value = [
        NamedQuery(name = "Encordadora.findAll", query = "select e from Encordadora e")
    ]
)
class Encordadora(
    id: Long,
    uuid: UUID = UUID.randomUUID(),
    marca: String,
    modelo: String,
    fechaAdquisicion: String,
    numSerie: Long,
    @Expose var isManual: Boolean,
    @Expose var tensionMax: Double,
    @Expose var tensionMin: Double,

    @OneToOne(fetch = FetchType.EAGER)
    var turno: Turno? = null,
) : Maquina(id, uuid, marca, modelo, fechaAdquisicion, numSerie) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}