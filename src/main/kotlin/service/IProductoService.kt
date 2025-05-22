package org.example.service

interface IProductoService {

    fun insertarProducto(nombre: String, precio: Double, stock: Int)
    fun eliminarProducto(precio: Double)
    fun modificarPrecioAOferta(nombre: String, precio: Double)

}