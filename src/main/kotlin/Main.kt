package org.example

import org.example.app.ConsLinPedido
import org.example.data.DataBase

fun main(){

    /*
    DataBase.getConnection()
    DataBase.initDatabase()
    DataBase.updateDatabase()
     */

    val lp = ConsLinPedido()

    lp.obtenerLineasPedido1()

}