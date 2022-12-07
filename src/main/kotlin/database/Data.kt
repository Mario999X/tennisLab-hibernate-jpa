package database

import models.Adquisicion
import models.Encordar
import models.Personalizar
import models.Producto

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