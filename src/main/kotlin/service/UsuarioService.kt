package org.example.service

import org.example.data.dao.ConsUsuario

class UsuarioService(val consUsuario: ConsUsuario): IUsuarioService {
    override fun insertarUsuario(nombre: String, email: String) {
        consUsuario.insertarUsuario(nombre, email)
    }

    override fun eliminarUsuario(nombre: String) {
        consUsuario.eliminaUsuario(nombre)
    }

    override fun mostrarPedidosReazlizadosPorUsuarios(nombre: String) {
        consUsuario.mostrarPedidosRealizados(nombre)
    }
}