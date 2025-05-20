package org.example.app

import org.example.data.DataBase.getConnection
import java.sql.SQLException

class ConsLinPedido {

    /**
     * Obtiene las líneas de pedido del id '1' en este caso.
     *
     * Se ejecuta una consulta en SQL para encontrar el producto y sus líneas de pedido.
     * En caso de error o excepción se capturará.
     */
    fun obtenerLineasPedido1() {
        try{
            val conn = getConnection()

            val stmt = conn?.prepareStatement("""
            SELECT p.nombre as producto, lp.cantidad, lp.precio 
            FROM LineaPedido lp
            JOIN Producto p ON lp.idProducto = p.id
            WHERE lp.idPedido = 1
        """)

            val rs = stmt?.executeQuery()

            println("Líneas del pedido 1")
            if (rs != null) {
                while (rs.next()) {println("Producto: ${rs.getString("producto")}, Cantidad:  ${rs.getString("cantidad")}, Precio:  ${rs.getString("precio")}")
                }
            }

            rs?.close()
            stmt?.close()
            conn?.close()
        }catch (e: SQLException){
            println("Error al ejecutar la consulta: ${e.message}")
        }
    }

    /**
     * Actualiza la línea de pedido con id igual a 3.
     * Cambia el producto a abanico, con id idugal a 2.
     * Se duplica el precio del abanico, es decir 2 * 120, 240.
     *
     * Se ejecuta una consulta en SQL para encontrar la línea de pedido esperada y modificarla.
     * En caso de error o excepción se capturará.
     */
    fun actualizarLineaPedido() {
        try {
            getConnection()?.use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeUpdate("""
                    UPDATE LineaPedido 
                    SET idProducto = 2,       
                        precio = 240.00         
                    WHERE id = 3                
                """.trimIndent())

                    println("Línea de pedido 3 actualizada.")
                }
            }
        } catch (e: SQLException) {
            println("Error al actualizar la línea de pedido: ${e.message}")
        }
    }

}