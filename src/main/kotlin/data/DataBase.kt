package org.example.data

import org.example.model.User
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DataBase {

    const val DB_URL = "jdbc:h2:./data/tienda"
    const val USER = "sa"
    const val PASS = ""

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(DB_URL, USER, PASS)
        } catch (e: SQLException) {
            System.err.println("Error al conectar a la base de datos: ${e.message}")
            null
        }
    }

    fun closeConnection(connection: Connection?) {
        try {
            connection?.close()
            println("Conexión cerrada correctamente")
        } catch (e: SQLException) {
            System.err.println("Error al cerrar la conexión: ${e.message}")
        }
    }

    fun initDatabase() {
        getConnection()?.use { conn ->
            conn.createStatement().use { stmt ->
                stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Usuario (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(255) NOT NULL,
                    email VARCHAR(255) UNIQUE
                )
            """.trimIndent())

                stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Producto (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(255) NOT NULL,
                    precio DECIMAL(10, 2) NOT NULL,
                    stock INT NOT NULL
                )
            """.trimIndent())

                stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Pedido (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    precioTotal DECIMAL(10, 2) NOT NULL,
                    idUsuario INT,
                    FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
                )
            """.trimIndent())

                stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS LineaPedido (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    cantidad INT NOT NULL,
                    precio DECIMAL(10, 2) NOT NULL,
                    idPedido INT,
                    idProducto INT,
                    FOREIGN KEY (idPedido) REFERENCES Pedido(id),
                    FOREIGN KEY (idProducto) REFERENCES Producto(id)
                )
            """.trimIndent())

                println("Tablas creadas correctamente")
            }
        }
    }

    fun createUser(name: String, email: String) {
        getConnection().use { conn ->
            val stmt = conn?.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")
            stmt?.setString(1, name)
            stmt?.setString(2, email)
            stmt?.executeUpdate()
        }
    }

    fun readUsers(): List<User> {
        val users = mutableListOf<User>()
        getConnection().use { conn ->
            val stmt = conn?.createStatement()
            val rs = stmt?.executeQuery("SELECT * FROM users")
            if (rs != null) {
                while (rs?.next() == true) {
                    users += User(rs.getInt("id"), rs.getString("name"), rs.getString("email"))
                }
            }
        }
        return users
    }

    fun updateUser(id: Int, name: String, email: String) {
        getConnection().use { conn ->
            val stmt = conn?.prepareStatement("UPDATE users SET name = ?, email = ? WHERE id = ?")
            stmt?.setString(1, name)
            stmt?.setString(2, email)
            stmt?.setInt(3, id)
            stmt?.executeUpdate()
        }
    }

    fun deleteUser(id: Int) {
        getConnection().use { conn ->
            val stmt = conn?.prepareStatement("DELETE FROM users WHERE id = ?")
            stmt?.setInt(1, id)
            stmt?.executeUpdate()
        }
    }


}