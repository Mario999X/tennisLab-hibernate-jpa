package repositoryTest

import database.HibernateManager
import models.Personalizar
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.personalizar.PersonalizarRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PersonalizarRepositoryImplTest {

    private val repository = PersonalizarRepositoryImpl()

    private val data = Personalizar(
        id = 5L,
        peso = 1.3,
        balance = 1.4,
        rigidez = 1
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM personalizaciones")
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