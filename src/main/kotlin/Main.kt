import controllers.AdquisicionController
import controllers.EncordarController
import controllers.PersonalizarController
import controllers.ProductoController
import database.*
import repository.adquisicion.AdquisicionRepositoryImpl
import repository.encordar.EncordarRepositoryImpl
import repository.personalizar.PersonalizarRepositoryImpl
import repository.producto.ProductoRepositoryImpl

fun main() {

    initDataBase()

    //Controladores
    val productoController = ProductoController(ProductoRepositoryImpl())
    val adquisicionController = AdquisicionController(AdquisicionRepositoryImpl())
    val encordarController = EncordarController(EncordarRepositoryImpl())
    val personalizarController = PersonalizarController(PersonalizarRepositoryImpl())

    //Inserción de datos
    val productosInit = getProductosInit()
    productosInit.forEach { producto ->
        productoController.createProducto(producto)
    }
    val adquisicionesInit = getAdquisicionInit()
    adquisicionesInit.forEach { adquisicion ->
        adquisicionController.createAdqusicion(adquisicion)
    }
    val encordadosInit = getEncordadosInit()
    encordadosInit.forEach { encordar ->
        encordarController.createEncordado(encordar)
    }
    val personalizacionesInit = getPersonalizacionInit()
    personalizacionesInit.forEach { personalizacion ->
        personalizarController.createPersonalizacion(personalizacion)
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

    //Encordar
    //FindAll
    val encordar = encordarController.getEncordados()
    encordar.forEach { println(it) }
    //FindById
    val encordadoId = encordarController.getEncordadoById(encordar[0].id)
    encordadoId?.let { println(it) }
    //Update
    val encordadoUpdate = encordarController.getEncordadoById(encordar[0].id)
    encordadoUpdate?.let {
        it.nudos += 2
        encordarController.updateEncordado(it)
    }
    println(encordadoUpdate)
    //Delete
    val encordadoDelete = encordarController.getEncordadoById(encordar[0].id)
    encordadoDelete?.let { if (encordarController.deleteEncordado(it)) println("Encordado eliminado") }

    //Personalizar
    //FindAll
    val personalizar = personalizarController.getPersonalizaciones()
    personalizar.forEach { println(it) }
    //FindById
    val personalizarId = personalizarController.getPersonalizacionById(personalizar[0].id)
    personalizarId?.let { println(it) }
    //Update
    val personalizarUpdate = personalizarController.getPersonalizacionById(personalizar[0].id)
    personalizarUpdate?.let {
        it.peso += 1
        personalizarController.updatePersonalizacion(personalizarUpdate)
    }
    println(personalizarUpdate)
    //Delete
    val personalizarDelete = personalizarController.getPersonalizacionById(personalizar[0].id)
    personalizarDelete?.let { if (personalizarController.deletePersonalizacion(it)) println("Personalización eliminada") }
}

fun initDataBase() {
    HibernateManager.open()
    HibernateManager.close()
}