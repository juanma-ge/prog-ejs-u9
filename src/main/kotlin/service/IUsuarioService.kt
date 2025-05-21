package org.example.service

interface IUsuarioService {

    fun insertarUsuario(nombre: String, email: String)
    fun eliminarUsuario(nombre: String)
    fun mostrarPedidosReazlizadosPorUsuarios(nombre: String)

}