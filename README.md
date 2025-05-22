# Introducción 
- Esta es, con diferencia, la rama o apartado más importante del programa, y donde está toda la aplicación.
- Consta de un menú principal, el cual varía entre otros cuatro submenús, a partir de ahí, podrás acceder a las funcionadlidades del programa.
- Está personalizado para que el usuario interactúe, y pueda decidir que usuarios eliminar, que pedidos introduir, etc. Y no con consultas prehechas, como en los ejercicios anteriores.
- Voy a explicar el programa capa a capa.
## App
- En este apartado está la clase Aplicación, que como he explicado antes, es donde funciona el menú principal.
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/app/Aplicacion.kt#L17-L45
- Al escoger entre las opciones y los submenús podrás utilizar, consultar e interactuar con la base de datos.
- Hay un submenú por cada elemento de la base de datos; Producto, Pedido, Línea de pedido y Usuario. Veamos el de usuario por poner un ejemplo:
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/app/Aplicacion.kt#L47-L94
## Data
- Es donde se ubica nuestra database como mencionamos anteriormente, pero además de eso, está nuestro DataSource, por donde se conectará con Hikari, además de un enum class 'Modo'.
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/data/DataBase.kt#L26-L46
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/data/DataBase.kt#L22-L24
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/data/DataBase.kt#L14-L16
- El programa tratará de conectarse con Hikari, pero si este falla, se conectará con una base de datos simple de H2, tal y como en los ejercicios anteriores.
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/data/DataBase.kt#L48-L64
### Dao
- Dentro de data, se encuentra la carpeta dao, donde lógicamente se encuentran todas nuestras clases dao.
- Cada elemento tiene su respectiva interfaz y clase, de donde se importan cada función que después interactuarán con el service.
- Aquí se crearán las funciones que posteriormente serán usadas por los usuarios para introducir sus datos. Por ejemplo:
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/data/dao/ConsLinPedido.kt#L116-L134
## Model 
- Contiene las clases que representan las entidades de la tienda.
- Usuario
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/model/User.kt#L3
- Producto
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/model/Producto.kt#L3
- Pedido
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/model/Pedido.kt#L3
- Línea de pedido
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/model/LinPedido.kt#L3
## Service
- Es la capa más externa y la lógica de negocio.
- En este caso tiene gran parte de las funciones compartidas con el dao, por ello para sus funciones llama a este, aunque eso no le resta importancia.
- Es de donde surgen y serán inyectadas las funciones para el funcionamiento de la aplicación.
- Al igual que en el dao, cada clase tiene su respectiva interfaz. Pongamos un ejemplo:
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/service/UsuarioService.kt#L5-L17
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/service/IUsuarioService.kt#L5-L7
## UI
- Son aquellas clases que manejan la interacción del usuario.
- Gracias a ellas el programa funciona correctamente y mejora su limpieza y buenas prácticas.
- Consta de 'Console' y su interfaz.

## Main
- Por último, en el main es donde se llaman a las funciones, en este caso he tratado de llenarlo lo menos posible.
- Solamente hago una variable de app para llamarlo más fácilmente, y desde allí llamo a menu(), donde funcionará el programa.
https://github.com/juanma-ge/prog-ejs-u9/blob/4fbe6a78b413014d4b9e7b92cb3b3719f2938b7b/src/main/kotlin/Main.kt#L5-L10

## Ejercicios
- Habalando sobre los ejercicios específicos de este apartado;
- El primer ejercicio se realiza con la función de insertar usuario, donde en sus respectivos datos deberemos de introducir el nombre y email dados.
https://github.com/juanma-ge/prog-ejs-u9/blob/9d67915a7dce63e228f590e4d3e3c2837c6c9551/src/main/kotlin/data/dao/ConsUsuario.kt#L114-L133
- El segundo ejercicio debe de realizar una consulta que busque los pedidos realizados por el usuario 'Facundo Pérez'.
https://github.com/juanma-ge/prog-ejs-u9/blob/9d67915a7dce63e228f590e4d3e3c2837c6c9551/src/main/kotlin/data/dao/ConsUsuario.kt#L160-L191
