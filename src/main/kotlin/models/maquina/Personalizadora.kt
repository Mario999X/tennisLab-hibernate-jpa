package models.maquina

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.Entity
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

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
    @Expose var rigidez: Boolean
) : Maquina(id, uuid, marca, modelo, fechaAdquisicion, numSerie) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}