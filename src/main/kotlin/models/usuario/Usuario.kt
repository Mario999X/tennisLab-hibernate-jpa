package models.usuario

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Usuario(
    @Id
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    var nombre: String,
    val apellido: String,
    val email: String,
    val password: String
) {
    enum class Perfil(val rol: String) {
        ADMIN("ENCARGADO"),
        ENCORDADOR("TRABAJADOR"),
        TENISTA("CLIENTE");

        companion object {
            fun from(perfil: String): Perfil {
                return when (perfil.uppercase()) {
                    "ENCARGADO" -> ADMIN
                    "TRABAJADOR" -> ENCORDADOR
                    "CLIENTE" -> TENISTA
                    else -> throw IllegalArgumentException("Rol no reconocido")
                }
            }
        }
    }
}