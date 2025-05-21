package org.example.data.dao

interface IConsProducto {

    fun eliminarProducto(nombre: String, precio: Double, stock: Int)
    fun modificarPrecioOferta(nombre: String)
    fun cambiarNombreProducto(nombre: String)
    fun modificarPrecioProductoDoble(nombre: String)
    fun insertarProducto(nombre: String, precio: Double, stock: Int)

}