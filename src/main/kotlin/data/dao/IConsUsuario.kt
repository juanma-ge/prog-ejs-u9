package org.example.data.dao

interface IConsUsuario {

    fun mostrarNombreUsuario(nombre: String)
    fun eliminaUsuario(nombre: String)
    fun insertarUsuario(nombre: String, email: String)
    fun mostrarPedidosRealizados(nombre: String)

}