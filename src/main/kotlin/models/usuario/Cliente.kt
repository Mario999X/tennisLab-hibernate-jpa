package models.usuario

import com.google.gson.GsonBuilder
import models.Raqueta
import utils.Cifrador
import java.util.*
import javax.persistence.*

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
    perfil: Perfil = Perfil.TENISTA,
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", orphanRemoval = true)
    var raquetas: MutableList<Raqueta> = mutableListOf()
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}