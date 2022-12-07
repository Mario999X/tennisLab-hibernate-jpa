package database

import models.Adquisicion
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