package models.usuario

import com.google.gson.GsonBuilder
import utils.Cifrador
import java.util.*
import javax.persistence.Entity
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

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
    perfil: Perfil = Perfil.ENCORDADOR
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}