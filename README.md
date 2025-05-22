# Ejercicio 2
## Introducción
- El segundo ejercicio constra de dos partes, crear la estructura de la base de datos que usaremos posteriormente, e insertar los datos iniciales.
## Database
- Los métodos para ello, están en la clase Databse, donde las funciones getConection() e initDatabase() ayudan a su conexión().
https://github.com/juanma-ge/prog-ejs-u9/blob/62cc137cb3a23eae7a1c4e65aa7954bab2daf5e2/src/main/kotlin/data/DataBase.kt#L32-L76
https://github.com/juanma-ge/prog-ejs-u9/blob/62cc137cb3a23eae7a1c4e65aa7954bab2daf5e2/src/main/kotlin/data/DataBase.kt#L14-L21
- Además funciones como closeConection() o updateDatabse() nos ayudarán en el futuro. Siendo también bastantes importantes.
https://github.com/juanma-ge/prog-ejs-u9/blob/62cc137cb3a23eae7a1c4e65aa7954bab2daf5e2/src/main/kotlin/data/DataBase.kt#L78-L113
https://github.com/juanma-ge/prog-ejs-u9/blob/62cc137cb3a23eae7a1c4e65aa7954bab2daf5e2/src/main/kotlin/data/DataBase.kt#L23-L30
## Tablas
- Como se ha podido ver anteriormente, para insertar las tablas, las cuales son las de usuarios, pedidos, líneas de pedido y producto, utilizaremos consultas en sql.
- Para insertar los datos también, con los que utilizaremos updateDatabase().
