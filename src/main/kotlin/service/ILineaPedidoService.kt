package org.example.service

interface ILineaPedidoService {

    fun insertarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int)
    fun eliminarLinPedido(idpedido: Int)
    fun modificarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int)

}