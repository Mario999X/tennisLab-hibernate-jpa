package database

import models.*
import models.maquina.Encordadora
import models.maquina.Personalizadora
import models.usuario.Cliente
import models.usuario.Encargado
import models.usuario.Trabajador
import java.time.LocalDate

/**
 * @author Sebastian Mendoza y Mario Resa
 */

fun getEncargadoInit() = listOf(
    Encargado(
        id = 1L,
        nombre = "Alberto",
        apellido = "Muñoz",
        email = "email@email.com",
        password = "1234"
    ),
    Encargado(
        id = 2L,
        nombre = "Elena",
        apellido = "Gonzalez",
        email = "email2@email.com",
        password = "5678"
    ),
    Encargado(
        id = 3L,
        nombre = "Elizabeth",
        apellido = "Merino",
        email = "email3@email.com",
        password = "4321"
    )
)

fun getClientesInit() = listOf(
    Cliente(
        id = 1L,
        nombre = "Sebastian",
        apellido = "Mendoza",
        email = "email@email.com",
        password = "1234"
    ),
    Cliente(
        id = 2L,
        nombre = "Mario",
        apellido = "Resa",
        email = "email2@email.com",
        password = "5678"
    ),
    Cliente(
        id = 3L,
        nombre = "Sandra",
        apellido = "Ortega",
        email = "email3@email.com",
        password = "4321"
    )
)

fun getTrabajadorInit() = listOf(
    Trabajador(
        id = 1L,
        nombre = "Adrian",
        apellido = "Garcia",
        email = "email@email.com",
        password = "1234"
    ),
    Trabajador(
        id = 2L,
        nombre = "Julian",
        apellido = "Estrada",
        email = "email2@email.com",
        password = "5678"
    ),
    Trabajador(
        id = 3L,
        nombre = "Camila",
        apellido = "Echeverri",
        email = "email3@email.com",
        password = "4321"
    )
)

fun getProductosInit() = listOf(
    Producto(
        id = 1L,
        tipo = Producto.Tipo.RAQUETA,
        marca = "Babolat",
        modelo = "Pure Aero",
        stock = 3,
        precio = 279.95
    ),
    Producto(
        id = 2L,
        tipo = Producto.Tipo.COMPLEMENTO,
        marca = "Wilson",
        modelo = "Dazzle",
        stock = 5,
        precio = 7.90
    ),
    Producto(
        id = 3L,
        tipo = Producto.Tipo.CORDAJE,
        marca = "Wilson",
        modelo = "Plastico",
        stock = 5,
        precio = 12.5
    )
)

fun getRaquetasInit() = listOf(
    Raqueta(
        marca = "Wilson",
        modelo = "Pure",
    ),
    Raqueta(
        marca = "Prueba",
        modelo = "Air",
    ),
    Raqueta(
        marca = "Nike",
        modelo = "Parallel",
    ),
)

fun getAdquisicionInit() = listOf(
    Adquisicion(
        id = 1L,
        cantidad = 1,
        producto = getProductosInit()[1],
    ),
    Adquisicion(
        id = 2L,
        cantidad = 4,
        producto = getProductosInit()[2]
    ),
    Adquisicion(
        id = 3L,
        cantidad = 2,
        producto = getProductosInit()[2]
    )
)

fun getEncordadosInit() = listOf(
    Encordar(
        id = 1L,
        tensionCuerdasHorizontales = 2.2,
        cordajeHorizontal = "Dato 1",
        tensionCuerdasVerticales = 1.2,
        cordajeVertical = "Dato 2",
        nudos = 2
    ),
    Encordar(
        id = 2L,
        tensionCuerdasHorizontales = 1.0,
        cordajeHorizontal = "Dato 1",
        tensionCuerdasVerticales = 2.2,
        cordajeVertical = "Dato 2",
        nudos = 4
    ), Encordar(
        id = 3L,
        tensionCuerdasHorizontales = 1.2,
        cordajeHorizontal = "Dato 1",
        tensionCuerdasVerticales = 3.2,
        cordajeVertical = "Dato 2",
        nudos = 2
    )
)

fun getPersonalizacionInit() = listOf(
    Personalizar(
        id = 1L,
        peso = 1.3,
        balance = 1.4,
        rigidez = 1
    ),
    Personalizar(
        id = 2L,
        peso = 1.5,
        balance = 1.7,
        rigidez = 1
    ),
    Personalizar(
        id = 3L,
        peso = 1.8,
        balance = 1.1,
        rigidez = 4
    ),
)

fun getPedidosInit() = listOf(
    Pedido(
        id = 1L,
        estado = Pedido.TipoEstado.RECIBIDO,
        fechaEntrada = LocalDate.now().toString(),
        fechaProgramada = LocalDate.now().plusDays(1).toString(),
        fechaSalida = LocalDate.now().plusDays(2).toString(),
        cliente = getClientesInit()[2]
    ),
    Pedido(
        id = 2L,
        estado = Pedido.TipoEstado.PROCESANDO,
        fechaEntrada = LocalDate.now().toString(),
        fechaProgramada = LocalDate.now().plusDays(1).toString(),
        fechaSalida = LocalDate.now().plusDays(2).toString(),
        cliente = getClientesInit()[0]
    )
)

fun getEncordadorasInit() = listOf(
    Encordadora(
        id = 1L,
        marca = "Toshiba",
        modelo = "ABC",
        fechaAdquisicion = LocalDate.now().minusDays(10).toString(),
        numSerie = 120L,
        isManual = true,
        tensionMax = 23.2,
        tensionMin = 20.5
    ),
    Encordadora(
        id = 2L,
        marca = "BBBBBBBBBBB",
        modelo = "ACB",
        fechaAdquisicion = LocalDate.now().minusDays(20).toString(),
        numSerie = 120L,
        isManual = false,
        tensionMax = 23.2,
        tensionMin = 20.5
    )
)

fun getPersonalizadorasInit() = listOf(
    Personalizadora(
        id = 1L,
        marca = "AAAAAAAAAAAAAA",
        modelo = "ABC",
        fechaAdquisicion = LocalDate.now().minusDays(50).toString(),
        numSerie = 120L,
        maniobrabilidad = true,
        balance = false,
        rigidez = false
    ),
    Personalizadora(
        id = 2L,
        marca = "ZZZZZZZZZ",
        modelo = "ZZZ",
        fechaAdquisicion = LocalDate.now().minusDays(60).toString(),
        numSerie = 340L,
        maniobrabilidad = true,
        balance = true,
        rigidez = false
    )
)

fun getTurnosInit() = listOf(
    Turno(
        id = 1L,
        horario = Turno.TipoHorario.TEMPRANO,
        encordadora = getEncordadorasInit()[0],
        trabajador = getTrabajadorInit()[2]
    )
)

fun getTareasInit() = listOf(
    Tarea(
        id = 1L,
        adquisicion = getAdquisicionInit()[1],
        personalizar = getPersonalizacionInit()[1],
        encordar = getEncordadosInit()[1],
        trabajador = getTrabajadorInit()[1]
    )
)