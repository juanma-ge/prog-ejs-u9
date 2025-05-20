package org.example

import org.example.app.ConsLinPedido
import org.example.app.ConsPedido
import org.example.app.ConsProducto
import org.example.app.ConsUsuario
import org.example.data.DataBase
import org.example.data.DataBase.updateDatabase

fun main(){

    /*
    DataBase.getConnection()
    DataBase.initDatabase()
    DataBase.updateDatabase()
     */

    val db = DataBase
    val lp = ConsLinPedido()
    val pe = ConsPedido()
    val us = ConsUsuario()
    val pr = ConsProducto()

    db.initDatabase()
    db.updateDatabase()

}