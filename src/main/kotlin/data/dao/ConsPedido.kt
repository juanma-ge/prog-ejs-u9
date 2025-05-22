package org.example.data.dao

import org.example.data.DataBase.getConnection
import org.example.ui.Console
import java.sql.SQLException

class ConsPedido: IConsPedido {

    val ui = Console()

    /**
     * Muestra el importe total de los pedidos realizados por el usuario 'Ataulfo Rodríguez'.
     *
     * Se ejecuta una consulta en SQL para encontrar los pedidos del usuario y sumarlos.
     * En caso de error o excepción se capturará.
     */
    fun mostrarImporte(){
        val conn = getConnection()

        val stmt = conn?.prepareStatement("""
            SELECT SUM(p.precioTotal) as precio
            FROM Pedido p
            JOIN Usuario u ON u.id = p.idUsuario
            WHERE u.nombre = ?
        """.trimIndent())

        stmt?.setString(1, "Ataulfo Rodríguez")

        val rs = stmt?.executeQuery()

        println("Suma total del importe: ")
        if (rs != null) {
            while (rs.next()) {
                println(rs.getString("precio"))
            }
        }

        rs?.close()
        conn?.close()
        stmt?.close()
    }

    /**
     * Elimina el pedido con id igual a '3'.
     *
     * Se ejecuta una consulta en SQL para encontrar el pedido y eliminarlo.
     * En caso de error o excepción se capturará.
     */
    fun eliminarPedido(preciototal: Double, idusuario: Int) {
        try{
            val conn = getConnection()

            conn?.prepareStatement("""
                DELETE FROM LINEAPEDIDO
                WHERE IDPEDIDO = ?
            """.trimIndent()).use { stmt ->
                stmt?.setInt(1, 3)
                stmt?.executeUpdate()
            }

            conn?.prepareStatement("""
                DELETE FROM PEDIDO 
                WHERE ID = ?
            """.trimIndent()).use { stmt ->
                stmt?.setInt(1, 3)
                stmt?.executeUpdate()
            }
        }catch (e: SQLException){
            println("Error al eliminar el pedido: ${e.message}")
        }
    }

    /**
     * Se elimina el usuario buscándolo por su id.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun eliminarPedidoPorUsuario(id: Int) {
        try {
            val sql = """DELETE FROM Pedido WHERE id = ?;"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setInt(1, id)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se inserta un producto, junto con sus datos, precio total e id de usuario.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun insertarPedido(precioTotal: Double, idUsuario: Int) {
        try {
            val sql = """INSERT INTO Pedido (precioTotal, idUsuario) VALUES (?, ?)"""
            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setDouble(1, precioTotal)
                    stmt.setInt(2, idUsuario)
                    stmt.executeUpdate()
                }
            }
        }catch (e: SQLException) {
            throw e
        }
    }

}