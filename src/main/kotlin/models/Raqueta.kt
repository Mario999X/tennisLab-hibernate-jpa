package models

import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class Raqueta(
    var uuid: UUID = UUID.randomUUID(),
    var marca: String,
    var modelo: String
)