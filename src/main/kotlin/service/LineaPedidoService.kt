package org.example.service

import org.example.data.dao.ConsLinPedido

class LineaPedidoService(ConsLinPedido: ConsLinPedido): ILineaPedidoService {
    override fun insertarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int) {
        TODO("Not yet implemented")
    }

    override fun eliminarLinPedido(cantidad: Int, precio: Double, idpedido: Int, idproducto: Int) {
        TODO("Not yet implemented")
    }
}