package repositoryTest

import database.HibernateManager
import models.Encordar
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.encordar.EncordarRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class EncordarRepositoryImplTest {

    private val repository = EncordarRepositoryImpl()

    private val data = Encordar(
        id = 5L,
        tensionCuerdasHorizontales = 2.2,
        cordajeHorizontal = "Dato 1",
        tensionCuerdasVerticales = 1.2,
        cordajeVertical = "Dato 2",
        nudos = 2
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM encordados")
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