package org.example.app

import org.example.data.DataBase.getConnection

class ConsPedido {

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

}