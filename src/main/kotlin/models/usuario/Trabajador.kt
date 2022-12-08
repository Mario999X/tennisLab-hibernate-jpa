package models.usuario

import com.google.gson.GsonBuilder
import models.Tarea
import models.Turno
import utils.Cifrador
import java.util.*
import javax.persistence.*

/**
 * @author Sebastian Mendoza y Mario Resa
 */
@Entity
@Table(name = "trabajadores")
@NamedQueries(
    value = [
        NamedQuery(name = "Trabajador.findAll", query = "select t from Trabajador t")
    ]
)
class Trabajador(
    id: Long,
    uuid: UUID = UUID.randomUUID(),
    nombre: String,
    apellido: String,
    email: String,
    password: String,
    perfil: Perfil = Perfil.ENCORDADOR,

    @OneToOne(fetch = FetchType.EAGER)
    var turno: Turno? = null,
    @OneToOne(fetch = FetchType.EAGER)
    var tarea: Tarea? = null
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}