package org.example.app

import org.example.data.dao.ConsPedido
import org.example.data.dao.ConsProducto
import org.example.data.dao.ConsUsuario
import org.example.service.PedidoService
import org.example.service.ProductoService
import org.example.service.UsuarioService
import java.util.*
/*
class Aplicación {

    val scanner = Scanner(System.`in`)
    val usuarioService = UsuarioService(ConsUsuario())
    val productoService = ProductoService(ConsProducto())
    val pedidoService = PedidoService(ConsPedido())

    fun menu() {
        var opcion: Int

        do {
            println("\n=== MENÚ PRINCIPAL ===")
            println("1. Gestión de Usuarios")
            println("2. Gestión de Productos")
            println("3. Gestión de Pedidos")
            println("4. Consultas Especiales")
            println("0. Salir")
            print("Seleccione una opción: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> menuUsuarios(usuarioService, scanner)
                2 -> menuProductos(productoService, scanner)
                3 -> menuPedidos(pedidoService, scanner)
                4 -> menuConsultas(pedidoService, scanner)
                0 -> println("Saliendo del sistema...")
                else -> println("Opción no válida")
            }
        } while (opcion != 0)
    }

    fun menuUsuarios(service: UsuarioService, scanner: Scanner) {
        var opcion: Int
        do {
            println("\n--- GESTIÓN DE USUARIOS ---")
            println("1. Insertar usuario")
            println("2. Eliminar usuario")
            println("3. Mostrar todos los usuarios")
            println("0. Volver al menú principal")
            print("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    print("Nombre: ")
                    val nombre = scanner.nextLine()
                    print("Email: ")
                    val email = scanner.nextLine()
                    service.insertarUsuario(id, nombre, email)
                }

                2 -> {
                    print("ID del usuario a eliminar: ")
                    val id = scanner.nextInt()
                    service.eliminarUsuario(id)
                }

                3 -> dao.ConsUsuario.mostrarNombreUsuario(nombre)
                0 -> return
                else -> println("Opción no válida")
            }
        } while (true)
    }

    fun menuProductos(service: ProductoService, scanner: Scanner) {
        var opcion: Int
        do {
            println("\n--- GESTIÓN DE PRODUCTOS ---")
            println("1. Insertar producto")
            println("2. Eliminar producto")
            println("3. Modificar precio")
            println("4. Mostrar todos los productos")
            println("0. Volver al menú principal")
            print("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    print("Nombre: ")
                    val nombre = scanner.nextLine()
                    print("Precio: ")
                    val precio = scanner.nextDouble()
                    print("Stock: ")
                    val stock = scanner.nextInt()
                    service.insertarProducto(nombre, precio, stock)
                }

                2 -> {
                    print("ID del producto a eliminar: ")
                    val id = scanner.nextInt()
                    service.eliminarProducto(id)
                }

                3 -> {
                    print("ID del producto a modificar: ")
                    val id = scanner.nextInt()
                    print("Nuevo precio: ")
                    val precio = scanner.nextDouble()
                    service.modificarPrecio(id, precio)
                }

                4 -> service.mostrarProductos()
                0 -> return
                else -> println("Opción no válida")
            }
        } while (true)
    }

    fun menuPedidos(service: PedidoService, scanner: Scanner) {
        var opcion: Int
        do {
            println("\n--- GESTIÓN DE PEDIDOS ---")
            println("1. Crear pedido")
            println("2. Eliminar pedido")
            println("3. Mostrar todos los pedidos")
            println("0. Volver al menú principal")
            print("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> {
                    print("ID Usuario: ")
                    val idUsuario = scanner.nextInt()
                    print("Precio total: ")
                    val precioTotal = scanner.nextDouble()
                    service.insertarPedido(precioTotal, idUsuario)
                }

                2 -> {
                    print("ID del pedido a eliminar: ")
                    val id = scanner.nextInt()
                    service.eliminarPedido(id)
                }

                3 -> service.mostrarPedidos()
                0 -> return
                else -> println("Opción no válida")
            }
        } while (true)
    }

    fun menuConsultas(service: PedidoService, scanner: Scanner) {
        var opcion: Int
        do {
            println("\n--- CONSULTAS ESPECIALES ---")
            println("1. Mostrar líneas de pedido ID=1")
            println("2. Suma pedidos de Ataulfo Rodríguez")
            println("3. Usuarios que compraron Abanico")
            println("0. Volver al menú principal")
            print("Seleccione: ")

            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> service.mostrarLineasPedido1()
                2 -> service.mostrarSumaAtaulfo()
                3 -> service.mostrarUsuariosAbanico()
                0 -> return
                else -> println("Opción no válida")
            }
        } while (true)

    }
}

 */