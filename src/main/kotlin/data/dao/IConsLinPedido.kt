package org.example.data.dao

interface IConsLinPedido {

    fun mostrarLinPedido(id: Int, idPedido: Int)
    fun mostrarSumaImporte(name: String)
    fun eliminarLinPedido(id: Int)
    fun modificarLinPedido(id: Int, precio: Double)

}