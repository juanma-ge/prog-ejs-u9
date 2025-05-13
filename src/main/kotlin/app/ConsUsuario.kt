package org.example.app

import org.example.data.DataBase.getConnection
import java.sql.SQLException

class ConsUsuario {

    /**
     * Muestra todos los usuarios los cuales hayan comprado el producto 'Abanico'.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    fun mostrarUsuarios(){
        try {
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
        }catch (e: SQLException){
            println("Error al ejecutar la consulta: ${e.message}")
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

}