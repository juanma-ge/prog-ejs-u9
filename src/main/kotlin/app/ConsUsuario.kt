package org.example.app

import org.example.data.DataBase.getConnection

class ConsUsuario {

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

}