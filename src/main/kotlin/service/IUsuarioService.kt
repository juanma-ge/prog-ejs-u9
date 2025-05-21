package org.example.service

interface IUsuarioService {

    fun insertarUsuario(id: Int, nombre: String, email: String)
    fun eliminarUsuario(id: Int, nombre: String, email: String)

}