package repositoryTest.maquina

import database.HibernateManager
import models.maquina.Encordadora
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.encordadora.EncordadoraRepositoryImpl
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class EncordadoraRepositoryImplTest {

    private val repository = EncordadoraRepositoryImpl()

    private val data = Encordadora(
        id = 5L,
        marca = "Toshiba",
        modelo = "ABC",
        fechaAdquisicion = LocalDate.now().minusDays(10).toString(),
        numSerie = 120L,
        isManual = true,
        tensionMax = 23.2,
        tensionMin = 20.5
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM encordadoras")
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