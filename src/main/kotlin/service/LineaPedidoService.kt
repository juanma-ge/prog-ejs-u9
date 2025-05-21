package org.example.service

import org.example.data.dao.ConsLinPedido

class LineaPedidoService(val consLinPedido: ConsLinPedido): ILineaPedidoService {
    override fun insertarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int) {
        consLinPedido.insertarLinPedido(cantidad, precio, idpedido, idproducto)
    }

    override fun eliminarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int) {
        consLinPedido.eliminarLinPedido(cantidad)
    }
}