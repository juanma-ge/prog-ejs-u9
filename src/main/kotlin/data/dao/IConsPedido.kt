package org.example.data.dao

import org.example.model.Pedido

interface IConsPedido {


    fun eliminarPedidoPorUsuario(id: Int)
    fun insertarPedido(precioTotal: Double, idUsuario: Int)

}