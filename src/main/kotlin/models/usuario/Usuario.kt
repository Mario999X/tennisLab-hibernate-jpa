package models.usuario

import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Usuario(
    @Id
    @Column(name = "id")
    val id: Long,
    val uuid: UUID = UUID.randomUUID(),
    var nombre: String,
    var apellido: String,
    var email: String,
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