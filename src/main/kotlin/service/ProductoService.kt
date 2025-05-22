package org.example.service

import org.example.data.dao.IConsProducto

class ProductoService(val consProducto: IConsProducto): IProductoService {

    override fun insertarProducto(nombre: String, precio: Double, stock: Int) {
        consProducto.insertarProducto(nombre, precio, stock)
    }

    override fun eliminarProducto(precio: Double) {
        consProducto.eliminarProducto(precio)
    }

    override fun modificarPrecioAOferta(nombre: String, precio: Double) {
        consProducto.modificarPrecioOferta(nombre, precio)
    }
}