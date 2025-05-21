package org.example.service

interface IPedidoService {

    fun insertarPedido(preciototal: Double, idusuario: Int)
    fun eliminarPedido(preciototal: Double, idusuario: Int)

}