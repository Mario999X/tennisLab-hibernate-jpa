package repositoryTest.usuario

import database.HibernateManager
import models.usuario.Trabajador
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.usuario.TrabajadorRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TrabajadorRepositoryImplTest {

    private val repository = TrabajadorRepositoryImpl()

    private val data = Trabajador(
        id = 5L,
        nombre = "Camila",
        apellido = "Echeverri",
        email = "email3@email.com",
        password = "4321"
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM trabajadores")
            query.executeUpdate()
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