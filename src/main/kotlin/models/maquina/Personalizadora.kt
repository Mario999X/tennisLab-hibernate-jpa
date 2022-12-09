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
@Table(name = "personalizadoras")
@NamedQueries(
    value = [
        NamedQuery(name = "Personalizadora.findAll", query = "select p from Personalizadora p")
    ]
)
class Personalizadora(
    id: Long,
    uuid: UUID = UUID.randomUUID(),
    marca: String,
    modelo: String,
    fechaAdquisicion: String,
    numSerie: Long,
    @Expose var maniobrabilidad: Boolean,
    @Expose var balance: Boolean,
    @Expose var rigidez: Boolean,

    @OneToOne(fetch = FetchType.EAGER)
    var turno: Turno? = null,
) : Maquina(id, uuid, marca, modelo, fechaAdquisicion, numSerie) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation()
            .create().toJson(this)
    }
}