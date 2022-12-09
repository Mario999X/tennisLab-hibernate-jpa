package repositoryTest.maquina

import database.HibernateManager
import models.maquina.Personalizadora
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.personalizadora.PersonalizadoraRepositoryImpl
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PersonalizadoraRepositoryImplTest {

    private val repository = PersonalizadoraRepositoryImpl()

    private val data = Personalizadora(
        id = 5L,
        marca = "AAAAAAAAAAAAAA",
        modelo = "ABC",
        fechaAdquisicion = LocalDate.now().minusDays(50).toString(),
        numSerie = 120L,
        maniobrabilidad = true,
        balance = false,
        rigidez = false
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM personalizadoras")
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