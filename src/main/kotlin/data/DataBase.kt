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

    fun updateDatabase(){
        getConnection().use { conn ->
            conn?.createStatement()?.executeUpdate("""
            INSERT INTO Usuario (nombre, email) VALUES
            ('Facundo Pérez', 'facuper@mail.com'),
            ('Ataulfo Rodríguez', 'ataurod@mail.com'),
            ('Cornelio Ramírez', 'Cornram@mail.com')
        """)

            conn?.createStatement()?.executeUpdate("""
            INSERT INTO Producto (nombre, precio, stock) VALUES
            ('Ventilador', 10.00, 2),
            ('Abanico', 150.00, 47),
            ('Estufa', 24.99, 1)
        """)

            conn?.createStatement()?.executeUpdate("""
            INSERT INTO Pedido (idUsuario, precioTotal) VALUES
            (2, 160.00),
            (1, 20.00),
            (2, 150.00)
        """)

            conn?.createStatement()?.executeUpdate("""
            INSERT INTO LineaPedido (idPedido, idProducto, cantidad, precio) VALUES
            (1, 1, 1, 10.00),
            (1, 2, 1, 150.00),
            (2, 1, 2, 20.00),
            (3, 2, 1, 150.00)
        """)

            conn?.close()
            println("Base de datos creada y datos insertados correctamente")

        }
    }

    fun reiniciarDatabase() {
        getConnection()?.use { conn ->
            conn.createStatement().use { stmt ->
                // Elimina los datos
                stmt.executeUpdate("DELETE FROM LineaPedido")
                stmt.executeUpdate("DELETE FROM Pedido")
                stmt.executeUpdate("DELETE FROM Producto")
                stmt.executeUpdate("DELETE FROM Usuario")

                // Reinicia los autoincrementos
                stmt.executeUpdate("ALTER TABLE Usuario ALTER COLUMN id RESTART WITH 1")
                stmt.executeUpdate("ALTER TABLE Producto ALTER COLUMN id RESTART WITH 1")
                stmt.executeUpdate("ALTER TABLE Pedido ALTER COLUMN id RESTART WITH 1")
                stmt.executeUpdate("ALTER TABLE LineaPedido ALTER COLUMN id RESTART WITH 1")

                // Inserta los datos iniciales
                updateDatabase()

                println("Datos reinicializados completamente")
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