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
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "uuid", column = Column(name = "raqueta_uuid")),
        AttributeOverride(name = "marca", column = Column(name = "raqueta_marca")),
        AttributeOverride(name = "modelo", column = Column(name = "raqueta_modelo"))
    )
    var raqueta: Raqueta? = null
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}