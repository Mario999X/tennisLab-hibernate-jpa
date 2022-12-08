package models.maquina

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.Entity
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

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
) : Maquina(id, uuid, marca, modelo, fechaAdquisicion, numSerie) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}