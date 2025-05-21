package org.example.service

import org.example.data.dao.IConsProducto

class ProductoService(val consProducto: IConsProducto): IProductoService {

    override fun insertarProducto(nombre: String, precio: Double, stock: Int) {
        consProducto.insertarProducto(nombre, precio, stock)
    }

    override fun eliminarProducto(nombre: String, precio: Double, stock: Int) {
        consProducto.eliminarProducto(nombre, precio, stock)
    }
}