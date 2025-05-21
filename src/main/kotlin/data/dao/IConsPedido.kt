package org.example.data.dao

import org.example.model.Pedido

interface IConsPedido {


    fun eliminarPedido(id: Int)
    fun insertarPedido(precioTotal: Double, idUsuario: Int)

}