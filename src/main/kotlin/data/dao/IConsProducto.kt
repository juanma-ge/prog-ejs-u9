package org.example.data.dao

interface IConsProducto {

    fun eliminarProducto(precio: Double)
    fun modificarPrecioOferta(nombre: String, precio: Double)
    fun cambiarPrecioProducto(nombre: String, idproducto: Int)
    fun modificarPrecioProductoDoble(nombre: String)
    fun insertarProducto(nombre: String, precio: Double, stock: Int)

}