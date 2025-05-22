package org.example.app

import org.example.data.dao.*
import org.example.service.LineaPedidoService
import org.example.service.PedidoService
import org.example.service.ProductoService
import org.example.service.UsuarioService
import org.example.ui.Console
import java.sql.SQLException
import java.util.*

class Aplicacion {

    val scanner = Scanner(System.`in`)
    val ui = Console()

    fun menu() {
        try{
            var opcion: Int
            do {
                ui.mostrar("\n=== MENÚ PRINCIPAL ===")
                ui.mostrar("\n1. Gestión de Usuarios")
                ui.mostrar("\n2. Gestión de Productos")
                ui.mostrar("\n3. Gestión de Pedidos")
                ui.mostrar("\n4. Gestión de Lineas de pedido")
                ui.mostrar("\n5. Salir")
                ui.mostrar("\nSeleccione una opción: ")

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

        }catch (e: SQLException){
            throw e
        }
    }

    fun menuUsuario() {
        try {
            val us = UsuarioService(ConsUsuario())


            var opcion: Int
            do {
                ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
                ui.mostrar("\n1. Insertar usuario")
                ui.mostrar("\n2. Eliminar usuario")
                ui.mostrar("\n3. Mostrar los pedidos de un usuario")
                ui.mostrar("\n4. Volver al menú principal")
                ui.mostrar("\nSeleccione: ")

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
                        val nombre = scanner.nextLine()
                        us.eliminarUsuario(nombre.toString())
                    }

                    3 -> {
                        ui.mostrar("Nombre del usuario a eliminar: ")
                        val nombre = scanner.nextLine()
                        us.mostrarPedidosReazlizadosPorUsuarios(nombre.toString())
                    }

                    4 -> return
                    else -> ui.mostrar("Opción no válida")
                }
            }while (true)
        }catch (e: SQLException){
            throw e
        }
    }

    fun menuProducto(){
        try {

            val pr = ProductoService(ConsProducto())
            var opcion: Int
            do{
                ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
                ui.mostrar("\n1. Insertar producto")
                ui.mostrar("\n2. Eliminar producto")
                ui.mostrar("\n3. Modificar precio en oferta")
                ui.mostrar("\n4. Volver al menú principal")
                ui.mostrar("\nSeleccione: ")

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
        }catch (e: SQLException){
            throw e
        }
    }

    fun menuPedido(){
        try {

            val pe = PedidoService(ConsPedido())
            var opcion: Int
            do{
                ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
                ui.mostrar("\n1. Insertar pedido")
                ui.mostrar("\n2. Eliminar pedido")
                ui.mostrar("\n3. Volver al menú principal")
                ui.mostrar("\nSeleccione: ")

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
        }catch (e: SQLException){
            throw e
        }
    }

    fun menuLinPedido(){
        try {
            val ln = LineaPedidoService(ConsLinPedido())
            var opcion: Int
            do{
                ui.mostrar("\n--- GESTIÓN DE USUARIOS ---")
                ui.mostrar("\n1. Insertar Linea de pedido")
                ui.mostrar("\n2. Eliminar Linea de pedido")
                ui.mostrar("\n3. Modificar Linea de pedido")
                ui.mostrar("\n4. Volver al menú principal")
                ui.mostrar("\nSeleccione: ")

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
        }catch (e: SQLException){
            throw e
        }
    }

}