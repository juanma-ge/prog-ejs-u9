package org.example.data.dao

import org.example.data.DataBase.getConnection
import org.example.ui.Console
import java.sql.SQLException

class ConsProducto: IConsProducto {

    val ui = Console()

    /**
     * Elimina el producto o productos los cuales tengan el mismo precio que el indicado.
     *
     * Se ejecuta una consulta en SQL para encontrar dichos productos.
     * En caso de error o excepción se capturará.
     */
    fun eliminarProducto(){
        try {
            val conn = getConnection()

            val stmt = conn?.prepareStatement("""
                DELETE FROM PRODUCTO    
                WHERE PRECIO = ?
            """.trimIndent())
            stmt?.setDouble(1, 24.99)

            val rowsAffected = stmt?.executeUpdate()
            if (rowsAffected != null) {
                if (rowsAffected > 0) {
                    println("El producto ha sido eliminado correctamente")
                }else{
                    println("El producto no ha podido ser eliminado o no ha sido encontrado.")
                }
            }

        }catch (e: SQLException){
            println("Error al eliminar el producto: ${e.message}")
        }
    }

    /**
     * Actualiza el precio del producto 'Abanico' a 120 euros.
     *
     * Se ejecuta una consulta en SQL para encontrar dicho producto y actualizar su precio.
     * En caso de error o excepción se capturará.
     */
    fun modificarPrecio() {
        try{
            getConnection()?.use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeUpdate("""
                UPDATE Producto 
                SET precio = 120.00 
                WHERE nombre = 'Abanico'
            """.trimIndent())

                    println("Precio del Abanico actualizado a 120€")
                }
            }
        }catch (e: SQLException){
            println("Error al intentar actualizar el producto: ${e.message}")
        }
    }

    /**
     * Elimina el producto que introduzca el usuario, este se buscará por su precio..
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun eliminarProducto(precio: Double) {
        try {
            val sql = """DELETE FROM Producto WHERE precio = ?;"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setDouble(1, precio)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se modificará el precio de un producto temporalmente, como una oferta, este se buscará por su nombre.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun modificarPrecioOferta(nombre: String, precio: Double) {
        try {
            val sql = """UPDATE Producto 
                        SET precio = ? 
                        WHERE nombre = ?;"""
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setDouble(1, precio)
                        stmt.setString(2, nombre)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se modificará el precio de un producto, duplicándolo, este se buscará por su id.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun cambiarPrecioProducto(nombre: String, idproducto: Int) {
        try {
            val sql = """
                UPDATE LineaPedido
                SET 
                    idProducto = ?,
                    precio = (SELECT precio * 2 FROM Producto WHERE id = 2)
                WHERE id = ?;
            """.trimIndent()
                getConnection()?.use { conn ->
                    conn.prepareStatement(sql).use { stmt ->
                        stmt.setInt(1, idproducto)
                        stmt.setInt(2, idproducto)
                        stmt.executeUpdate()
                    }
                }
        }catch (e: SQLException) {
            throw e
        }
    }

    /**
     * Se modificará el precio de un producto, este se buscará por su nombre.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun modificarPrecioProductoDoble(nombre: String) {
        try {
            val sql = """
                UPDATE Producto 
                SET precio = 120 
                WHERE nombre = ?;
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
     * Se inserta un producto, junto con sus datos, nombre, precio y stock.
     *
     * Se ejecuta una consulta en SQL para encontrar los usuarios.
     * En caso de error o excepción se capturará.
     */
    override fun insertarProducto(nombre: String, precio: Double, stock: Int) {
        try {
            val sql = """INSERT INTO Producto (nombre, precio, stock) VALUES (?, ?, ?)"""
            getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, nombre)
                    stmt.setDouble(2, precio)
                    stmt.setInt(3, stock)
                    stmt.executeUpdate()
                }
            }
        }catch (e: SQLException) {
            throw e
        }
    }

}