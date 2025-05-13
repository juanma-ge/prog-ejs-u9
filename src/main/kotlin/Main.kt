package org.example

import org.example.app.ConsLinPedido
import org.example.app.ConsPedido
import org.example.app.ConsUsuario
import org.example.data.DataBase

fun main(){

    /*
    DataBase.getConnection()
    DataBase.initDatabase()
    DataBase.updateDatabase()
     */

    val lp = ConsLinPedido()
    val pe = ConsPedido()
    val us = ConsUsuario()

    lp.obtenerLineasPedido1()
    pe.mostrarImporte()
    us.mostrarUsuarios()

}