package org.example.app

import org.example.data.dao.ConsUsuario
import org.example.service.UsuarioService
import org.example.ui.Console
import java.util.*

class Aplicacion {

    val scanner = Scanner(System.`in`)
    val ui = Console()

    fun menu() {
        var opcion: Int
        do {
            ui.mostrar("\n=== MENÚ PRINCIPAL ===")
            ui.mostrar("1. Gestión de Usuarios")
            ui.mostrar("2. Gestión de Productos")
            ui.mostrar("3. Gestión de Pedidos")
            ui.mostrar("4. Gestión de Lineas de pedido")
            ui.mostrar("0. Salir")
            ui.mostrar("Seleccione una opción: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {

            }
        }

    }

    fun menuUsuario() {
        val us = UsuarioService(ConsUsuario())


        var opcion: Int
        do {
            println("\n--- GESTIÓN DE USUARIOS ---")
            println("1. Insertar usuario")
            println("2. Eliminar usuario")
            println("3. Mostrar los pedidos de un usuario")
            println("4. Volver al menú principal")
            print("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {

                1 -> {
                    print("Nombre: ")
                    val nombre = scanner.nextLine()
                    print("Email: ")
                    val email = scanner.nextLine()
                    us.insertarUsuario(nombre, email)

                }

                2 -> {
                    print("Nombre del usuario a eliminar: ")
                    val nombre = scanner.nextInt()
                    us.eliminarUsuario(nombre.toString())
                }

                3 -> {
                    print("Nombre del usuario a eliminar: ")
                    val nombre = scanner.nextInt()
                    us.mostrarPedidosReazlizadosPorUsuarios(nombre.toString())
                }

                4 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)
    }

}