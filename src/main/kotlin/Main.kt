import controllers.AdquisicionController
import controllers.ProductoController
import database.HibernateManager
import database.getAdquisicionInit
import database.getProductosInit
import repository.adquisicion.AdquisicionRepositoryImpl
import repository.producto.ProductoRepositoryImpl

fun main() {

    initDataBase()

    //Controladores
    val productoController = ProductoController(ProductoRepositoryImpl())
    val adquisicionController = AdquisicionController(AdquisicionRepositoryImpl())

    //Inserción de datos
    val productosInit = getProductosInit()
    productosInit.forEach { producto ->
        productoController.createProducto(producto)
    }
    val adquisicionesInit = getAdquisicionInit()
    adquisicionesInit.forEach { adquisicion ->
        adquisicionController.createAdqusicion(adquisicion)
    }

    //CRUD
    //Producto
    //FindAll
    val producto = productoController.getProductos()
    producto.forEach { println(it) }
    //FindById
    val productoId = productoController.getProductoById(producto[0].id)
    productoId?.let { println(it) }
    //Update
    val productoUpdate = productoController.getProductoById(producto[0].id)
    productoUpdate?.let {
        it.stock += 3
        productoController.updateProducto(it)
    }
    println(productoUpdate)
    //Delete
    val productoDelete = productoController.getProductoById(producto[0].id)
    productoDelete?.let { if (productoController.deleteProducto(it)) println("Producto eliminado") }

    //Adquisicion
    //FindAll
    val adquisicion = adquisicionController.getAdquisiciones()
    adquisicion.forEach { println(it) }
    //FindById
    val adquisicionId = adquisicionController.getAdquisicionById(adquisicion[0].id)
    adquisicionId?.let { println(it) }
    //Update
    val adquisicionUpdate = adquisicionController.getAdquisicionById(adquisicion[0].id)
    adquisicionUpdate?.let {
        it.cantidad += 1
        it.precio = it.precio?.times(it.cantidad)
        adquisicionController.updateAdquisicion(it)
    }
    println(adquisicionUpdate)
    //Delete
    val adquisicionDelete = adquisicionController.getAdquisicionById(adquisicion[0].id)
    adquisicionDelete?.let { if (adquisicionController.deleteAdquisicion(it)) println("Adquisicion eliminada") }

}

fun initDataBase() {
    HibernateManager.open()
    HibernateManager.close()
}