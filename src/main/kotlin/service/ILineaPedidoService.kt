package org.example.service

interface ILineaPedidoService {

    fun insertarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int)
    fun eliminarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int)
    fun modificarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int)

}