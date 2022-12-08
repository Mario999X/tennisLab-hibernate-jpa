package models.maquina

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Maquina(
    @Id
    @Expose val id: Long,
    @Expose val uuid: UUID,
    @Expose var marca: String,
    @Expose var modelo: String,
    @Expose var fechaAdquisicion: String,
    @Expose var numSerie: Long
) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}