package org.example.service

import org.example.data.dao.ConsUsuario

class UsuarioService(val consUsuario: ConsUsuario): IUsuarioService {
    override fun insertarUsuario(id: Int, nombre: String, email: String) {
        consUsuario.insertarUsuario(nombre, email)
    }

    override fun eliminarUsuario(id: Int, nombre: String, email: String) {
        consUsuario.eliminaUsuario(nombre)
    }
}