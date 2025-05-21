package org.example.service

import org.example.data.dao.ConsPedido

class PedidoService(val consPedido: ConsPedido): IPedidoService {
    override fun insertarPedido(preciototal: Double, idusuario: Int) {
        consPedido.insertarPedido(preciototal, idusuario)
    }

    override fun eliminarPedido(preciototal: Double, idusuario: Int) {
        consPedido.eliminarPedido(preciototal, idusuario)
    }
}