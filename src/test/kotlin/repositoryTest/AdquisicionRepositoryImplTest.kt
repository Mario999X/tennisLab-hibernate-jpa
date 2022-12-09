package repositoryTest

import database.HibernateManager
import models.Adquisicion
import models.Producto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import repository.adquisicion.AdquisicionRepositoryImpl

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AdquisicionRepositoryImplTest {

    private val repository = AdquisicionRepositoryImpl()

    private val data2 = Producto(
        id = 5L,
        tipo = Producto.Tipo.RAQUETA,
        marca = "Babolat",
        modelo = "Pure Aero",
        stock = 3,
        precio = 279.95
    )

    private val data = Adquisicion(
        id = 5L,
        cantidad = 2,
        producto = data2
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM adquisiciones")
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