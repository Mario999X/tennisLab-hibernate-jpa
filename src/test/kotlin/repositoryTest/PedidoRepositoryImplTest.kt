package repositoryTest

import database.HibernateManager
import models.Pedido
import models.Personalizar
import models.Tarea
import models.usuario.Trabajador
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import repository.pedido.PedidoRepositoryImpl
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PedidoRepositoryImplTest {

    private val repository = PedidoRepositoryImpl()

    private val data2 = Personalizar(
        id = 5L,
        peso = 1.3,
        balance = 1.4,
        rigidez = 1
    )

    private val data3 = Trabajador(
        id = 5L,
        nombre = "Camila",
        apellido = "Echeverri",
        email = "email3@email.com",
        password = "4321"
    )

    private val tareas = listOf(
        Tarea(
            id = 5L,
            personalizar = data2,
            precio = data2.precio,
            trabajador = data3
        )
    )

    private val data = Pedido(
        id = 5L,
        estado = Pedido.TipoEstado.PROCESANDO,
        fechaEntrada = LocalDate.now().toString(),
        fechaProgramada = LocalDate.now().plusDays(1).toString(),
        fechaSalida = LocalDate.now().plusDays(2).toString(),
        tareas = tareas.toMutableList()
    )

    @BeforeEach
    fun setUp() {
        HibernateManager.transaction {
            val query = HibernateManager.manager.createNativeQuery("DELETE FROM tareas")
            query.executeUpdate()
        }

        HibernateManager.transaction {
            HibernateManager.manager.merge(data2)
        }

        HibernateManager.transaction {
            HibernateManager.manager.merge(data3)
        }

        HibernateManager.transaction {
            HibernateManager.manager.merge(tareas[0])
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