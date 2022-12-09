package models.usuario

import com.google.gson.GsonBuilder
import utils.Cifrador
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

/**
 * @author Sebastian Mendoza y Mario Resa
 */
@Entity
@Table(name = "encargados")
@NamedQueries(
    value = [
        NamedQuery(name = "Encargado.findAll", query = "select e from Encargado e")
    ]
)
class Encargado(
    id: Long,
    uuid: UUID = UUID.randomUUID(),
    nombre: String,
    apellido: String,
    email: String,
    password: String,
    perfil: Perfil = Perfil.ADMIN
) : Usuario(id, uuid, nombre, apellido, email, Cifrador.encryptString(password)) {
    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting()
            .create().toJson(this)
    }
}