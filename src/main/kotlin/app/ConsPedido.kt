package org.example.app

import org.example.data.DataBase.getConnection
import java.sql.SQLException

class ConsPedido {

    /**
     * Muestra el importe total de los pedidos realizados por el usuario 'Ataulfo Rodríguez'.
     *
     * Se ejecuta una consulta en SQL para encontrar los pedidos del usuario y sumarlos.
     * En caso de error o excepción se capturará.
     */
    fun mostrarImporte(){
        try{
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
        }catch (e: SQLException){
            println("Error al ejecutar la consulta: ${e.message}")
        }
    }

    /**
     *
     *
     *
     */
    fun eliminarPedido(){
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

}