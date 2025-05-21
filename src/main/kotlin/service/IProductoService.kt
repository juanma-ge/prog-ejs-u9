package org.example.service

interface IProductoService {

    fun insertarProducto(nombre: String, precio: Double, stock: Int)
    fun eliminarProducto(nombre: String, precio: Double, stock: Int)

}