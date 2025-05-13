package org.example.app

import org.example.data.DataBase.getConnection

class ConsLinPedido {

    fun obtenerLineasPedido1() {
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
    }

}