package org.example.data.dao

interface IConsProducto {

    fun eliminarProducto(precio: Double)
    fun modificarPrecioOferta(nombre: String)
    fun cambiarNombreProducto(nombre: String)
    fun modificarPrecioProductoDoble(nombre: String)

}