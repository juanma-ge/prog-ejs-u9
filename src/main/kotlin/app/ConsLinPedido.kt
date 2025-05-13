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

}