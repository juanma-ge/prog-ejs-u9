package org.example.service

interface IProductoService {

    fun insertarProducto(nombre: String, precio: Int, stock: Int)
    fun eliminarProducto(nombre: String, precio: Int, stock: Int)

}