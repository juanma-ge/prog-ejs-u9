package org.example.data.dao

import org.example.data.DataBase.getConnection
import org.example.ui.Console
import java.sql.SQLException
import javax.sql.DataSource

class ConsLinPedido(): IConsLinPedido {

    val ui = Console()

    /**
     * Obtiene las líneas de pedido del id '1' en este caso.
     *
     * Se ejecuta una consulta en SQL para encontrar el producto y sus líneas de pedido.
     * En caso de error o excepción se capturará.
     */
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

    /**
     * Muestra la línea de pedido cuyo id de pedido sea insertado por el usuario.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun mostrarLinPedido(id: Int, idPedido: Int) {
        try {
            val sql = """
                        SELECT * FROM LineaPedido WHERE idPedido = ?;
                    """
            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, idPedido)
                    stmt.executeUpdate()
                }
            }

        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Muestra la suma total del importe.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun mostrarSumaImporte(name: String) {
        try {
            val sql = """
                SELECT SUM(p.precioTotal) AS total_gastado
                FROM Pedido p
                JOIN Usuario u ON p.idUsuario = u.id
                WHERE u.nombre = ?;
            """.trimIndent()
            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, name)
                    stmt.executeUpdate()
                }
            }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Elimina la línea de pedido buscándola por el id del pedido.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun eliminarLinPedido(idPedido: Int) {
        try {
            val sql = """DELETE FROM LineaPedido WHERE idPedido = ?;"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setInt(1, idPedido)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se modifica el precio de la línea de pedido.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun modificarLinPedido(id: Int, idProducto: Int) {
        try {
            val sql = """
                UPDATE LineaPedido
                SET 
                    idProducto = ?,
                    precio = (SELECT precio * 2 FROM Producto WHERE id = ?)
                WHERE id = ?;
            """.trimIndent()
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setInt(1, idProducto)
                        stmt.setInt(2, id)
                        stmt.setInt(3, id)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se inserta una línea de pedido, junto con sus datos, cantidad, precio, id de pedido e id de producto.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun insertarLinPedido(cantidad: Int, precio: Double, idPedido: Int, idProducto: Int) {
        try {
            val sql = """INSERT INTO LinPedido (cantidad, precio, idPedido, idproducto) VALUES (?, ?, ? , ?)"""
            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, cantidad)
                    stmt.setDouble(2, precio)
                    stmt.setInt(3, idPedido)
                    stmt.setInt(4, idProducto)
                    stmt.executeUpdate()
                }
            }
        }catch (e: SQLException) {
            throw e
        }
    }

}