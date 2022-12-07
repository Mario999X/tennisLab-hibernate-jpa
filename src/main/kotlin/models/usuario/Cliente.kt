package models.usuario

import com.google.gson.GsonBuilder
import utils.Cifrador
import java.util.*
import javax.persistence.Entity
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

@Entity
@Table(name = "clientes")
@NamedQueries(
    value = [
        NamedQuery(name = "Cliente.findAll", query = "select c from Cliente c")
    ]
)
class Cliente(
    id: Long,
    uuid: UUID = UUID.randomUUID(),
    nombre: String,
    apellido: String,
    email: String,
    password: String,
    perfil: Perfil = Perfil.TENISTA
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}