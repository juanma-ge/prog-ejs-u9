# Práctica 9.1: Acceso a datos I
## Introducción 
- Por temas de limpieza y facilidad, he creado un readme por rama, es decir, por ejercicio.
- El programa se ha dividido en 6 ramas, las cuales cada una complementa a cada uno de los ejercicios.
- Debido a que en el último ejercicio se utiliza Hikari, y lo he utilizado en el mismo 'DataBase', se utiliza también aquí, fallo técnico, pero se puede ver el commit anterior si no se quiere ver utilizado por Hikari. 
## Ejercicio 1
- El primer ejercicio consta simplemente de instalar la base H2 y conectarla.
- Instalamos las dependencias necessrias.
https://github.com/juanma-ge/prog-ejs-u9/blob/2882b0fbac951ade1a2fadf04ddd563198cf257f/build.gradle.kts#L14
- Establecemos un PATH por donde se va a conectar con la base de datos, donde posteriormente se insertarán las tablas.
- https://github.com/juanma-ge/prog-ejs-u9/blob/2882b0fbac951ade1a2fadf04ddd563198cf257f/src/main/kotlin/data/DataBase.kt#L21-L23
- Utilizo try and catch en cada función para asegurarme su correcto funcionamiento, y en caso de que no, que no de error.
https://github.com/juanma-ge/prog-ejs-u9/blob/439f7489e94e183d323d60ae139d9120598781c2/src/main/kotlin/app/ConsLinPedido.kt#L14-L39
https://github.com/juanma-ge/prog-ejs-u9/blob/439f7489e94e183d323d60ae139d9120598781c2/src/main/kotlin/app/ConsLinPedido.kt#L49-L68
