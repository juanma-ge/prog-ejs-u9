package org.example.data.dao

import org.example.data.DataBase.getConnection
import org.example.ui.Console
import java.sql.SQLException

class ConsUsuario: IConsUsuario {

    val ui = Console()

    /**
     * Muestra todos los usuarios los cuales hayan comprado el producto 'Abanico'.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    fun mostrarUsuarios(){
        val conn = getConnection()

        val stmt = conn?.prepareStatement("""
        SELECT DISTINCT u.nombre            
        FROM Usuario u
        JOIN Pedido pe ON u.id = pe.idUsuario 
        JOIN LineaPedido lp ON pe.id = lp.idPedido 
        JOIN Producto pr ON lp.idProducto = pr.id 
        WHERE pr.nombre = ?               
        """)
        stmt?.setString(1, "Abanico")

        val rs = stmt?.executeQuery()

        if (rs != null) {
            while (rs.next()){println("Usuarios que han comprado el producto 'Abanico': ${rs.getString("nombre")}")}
        }
    }

    /**
     * Elimina el usuario 'Cornelio Ramírez' de la base de datos.
     *
     * Se ejecuta una consulta en SQL para encontrar al usuario.
     * En caso de error o excepción se capturará.
     */
    fun eliminarUsuario(){
        try {
            val conn = getConnection()

            val stmt = conn?.prepareStatement("""
            DELETE FROM Usuario
            WHERE NOMBRE = ?
        """.trimIndent())
            stmt?.setString(1, "Cornelio Ramírez")

            val rowsAffected = stmt?.executeUpdate()

            if (rowsAffected != null) {
                if (rowsAffected > 0) {
                    println("El usuario 'Cornelio Ramirez' ha sido eliminado correctamente.")
                } else {
                    println("No se encontró el usuario 'Cornelio Ramírez' para eliminar.")
                }
            }
        }catch (e: SQLException){
            println("Error al eliminar al usuario: ${e.message}")
        }
    }

    /**
     * Muestra todos los usuarios el cual introduzca el usuario.
     *
     * Se ejecuta una consulta en SQL para encontrarlo.
     * En caso de error o excepción se capturará.
     */
    override fun mostrarNombreUsuario(nombre: String) {
        try {
            val sql = """
                SELECT DISTINCT u.nombre
                FROM Usuario u
                JOIN Pedido p ON u.id = p.idUsuario
                JOIN LineaPedido lp ON p.id = lp.idPedido
                JOIN Producto pr ON lp.idProducto = pr.id
                WHERE pr.nombre = ?;
            """.trimIndent()
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setString(1, nombre)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Elimina el usuario que introduzca el usuario.
     *
     * Se ejecuta una consulta en SQL para encontrarlo y eliminarlo.
     * En caso de error o excepción se capturará.
     */
    override fun eliminaUsuario(nombre: String) {
        try {
            val sql ="""DELETE FROM Usuario WHERE nombre = ?;"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setString(1, nombre)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Muestra todos los usuarios los cuales hayan comprado el producto 'Abanico'.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun insertarUsuario(nombre: String, email: String) {
        try {
            val sql = """INSERT INTO Usuario (nombre, email) VALUES (?, ?)"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setString(1, nombre)
                        stmt.setString(2, email)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Muestra todos los pedidos realizados por el usuario que introduzca el usuario.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun mostrarPedidosRealizados(nombre: String) {
        try {
            val sql = """
            SELECT p.id, p.precioTotal 
            FROM Pedido p
            JOIN Usuario u ON p.idUsuario = u.id
            WHERE u.nombre = ?;
            """.trimIndent()
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setString(1, nombre)
                        stmt.executeQuery()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Muestra todos pedidos realizados por el usuario 'Facundo Pérez'.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    fun mostrarPedidosRealizadosUsuario() {
        try {
            val sql = """
        SELECT p.id, p.precioTotal 
        FROM Pedido p
        JOIN Usuario u ON p.idUsuario = u.id
        WHERE u.nombre = 'Facundo Pérez'
        """.trimIndent()

            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    val rs = stmt.executeQuery()

                    while (rs.next()) {
                        val id = rs.getInt("id")
                        val precioTotal = rs.getDouble("precioTotal")
                        println("ID Pedido: $id, Precio Total: $precioTotal")
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

}