package repositoryTest

import database.HibernateManager
import models.Turno
import models.usuario.Trabajador
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.turno.TurnoRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TurnoRepositoryImplTest {

    private val repository = TurnoRepositoryImpl()

    private val data2 = Trabajador(
        id = 3L,
        nombre = "Camila",
        apellido = "Echeverri",
        email = "email3@email.com",
        password = "4321"
    )

    private val data = Turno(
        id = 5L,
        horario = Turno.TipoHorario.TEMPRANO,
        trabajador = data2
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM turnos")
            query.executeUpdate()
        }

        HibernateManager.transaction {
            HibernateManager.manager.merge(data2)
        }

        HibernateManager.transaction {
            HibernateManager.manager.merge(data)
        }
    }

    @Test
    fun findAll() {
        val res = repository.findAll()
        assertEquals(res[0].id, data.id)
    }

    @Test
    fun findById() {
        val res = repository.findById(data.id)
        assert(5L == res?.id)
    }

    @Test
    fun save() {
        val res = repository.save(data)
        assert(res.id == data.id)
    }

    @Test
    fun delete() {
        repository.delete(data)
        val res = repository.findById(data.id)
        assertNull(res)
    }
}