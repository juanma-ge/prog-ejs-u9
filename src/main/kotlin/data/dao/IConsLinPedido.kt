package org.example.data.dao

interface IConsLinPedido {

    fun mostrarLinPedido(id: Int, idPedido: Int)
    fun mostrarSumaImporte(name: String)
    fun eliminarLinPedido(idPedido: Int)
    fun modificarLinPedido(id: Int, idProducto: Int)
    fun insertarLinPedido(cantidad: Int, precio: Double, idPedido: Int, idProducto: Int)

}