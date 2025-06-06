package org.example.app

import org.example.data.DataBase.getConnection
import java.sql.SQLException

class ConsProducto {

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

}