package repositoryTest.usuario

import database.HibernateManager
import models.usuario.Encargado
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.usuario.EncargadoRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class EncargadoRepositoryImplTest {

    private val repository = EncargadoRepositoryImpl()

    private val data = Encargado(
        id = 5L,
        nombre = "Elizabeth",
        apellido = "Merino",
        email = "email3@email.com",
        password = "4321"
    )


    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM productos")
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