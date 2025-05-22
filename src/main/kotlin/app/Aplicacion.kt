package org.example.app

import org.example.data.dao.*
import org.example.service.LineaPedidoService
import org.example.service.PedidoService
import org.example.service.ProductoService
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
            ui.mostrar("5. Salir")
            ui.mostrar("Seleccione una opción: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> menuUsuario()
                2 -> menuProducto()
                3 -> menuPedido()
                4 -> menuLinPedido()
                5 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)

    }

    fun menuUsuario() {
        val us = UsuarioService(ConsUsuario())


        var opcion: Int
        do {
            ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
            ui.mostrar("1. Insertar usuario")
            ui.mostrar("2. Eliminar usuario")
            ui.mostrar("3. Mostrar los pedidos de un usuario")
            ui.mostrar("4. Volver al menú principal")
            ui.mostrar("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {

                1 -> {
                    ui.mostrar("Nombre: ")
                    val nombre = scanner.nextLine()
                    ui.mostrar("Email: ")
                    val email = scanner.nextLine()
                    us.insertarUsuario(nombre, email)

                }

                2 -> {
                    ui.mostrar("Nombre del usuario a eliminar: ")
                    val nombre = scanner.nextInt()
                    us.eliminarUsuario(nombre.toString())
                }

                3 -> {
                    ui.mostrar("Nombre del usuario a eliminar: ")
                    val nombre = scanner.nextInt()
                    us.mostrarPedidosReazlizadosPorUsuarios(nombre.toString())
                }

                4 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)
    }

    fun menuProducto(){

        val pr = ProductoService(ConsProducto())
        var opcion: Int
        do{
            ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
            ui.mostrar("1. Insertar producto")
            ui.mostrar("2. Eliminar producto")
            ui.mostrar("3. Modificar precio en oferta")
            ui.mostrar("4. Volver al menú principal")
            ui.mostrar("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    ui.mostrar("Nombre: ")
                    val nombre = scanner.nextLine()
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    ui.mostrar("Stock:")
                    val stock = scanner.nextLine().toInt()
                    pr.insertarProducto(nombre, precio, stock)
                }
                2 -> {
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    pr.eliminarProducto(precio)
                }
                3 -> {
                    ui.mostrar("Nombre: ")
                    val nombre = scanner.nextLine()
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    pr.modificarPrecioAOferta(nombre, precio)
                }
                4 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)
    }

    fun menuPedido(){

        val pe = PedidoService(ConsPedido())
        var opcion: Int
        do{
            ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
            ui.mostrar("1. Insertar pedido")
            ui.mostrar("2. Eliminar pedido")
            ui.mostrar("3. Volver al menú principal")
            ui.mostrar("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    ui.mostrar("IdUsuario: ")
                    val idUsuario = scanner.nextLine().toInt()
                    pe.insertarPedido(precio, idUsuario)
                }
                2 -> {
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    ui.mostrar("IdUsuario: ")
                    val idUsuario = scanner.nextLine().toInt()
                    pe.eliminarPedido(precio, idUsuario)
                }
                3 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)
    }

    fun menuLinPedido(){
        val ln = LineaPedidoService(ConsLinPedido())
        var opcion: Int
        do{
            ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
            ui.mostrar("1. Insertar Linea de pedido")
            ui.mostrar("2. Eliminar Linea de pedido")
            ui.mostrar("3. Modificar Linea de pedido")
            ui.mostrar("4. Volver al menú principal")
            ui.mostrar("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    ui.mostrar("Cantidad: ")
                    val cantidad = scanner.nextLine().toInt()
                    ui.mostrar("Precio: ")
                    val precio = scanner.nextLine().toDouble()
                    ui.mostrar("IdPedido: ")
                    val idPedido = scanner.nextLine().toInt()
                    ui.mostrar("IdProducto: ")
                    val idProducto = scanner.nextLine().toInt()
                    ln.insertarLinPedido(cantidad, precio, idPedido, idProducto)
                }
                2 -> {
                    ui.mostrar("IdPedido: ")
                    val idPedido = scanner.nextLine().toInt()
                    ln.eliminarLinPedido(idPedido)
                }
                3 -> return
                else -> ui.mostrar("Opción no válida")
            }
        }while (true)
    }

}