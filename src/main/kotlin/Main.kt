package org.example

import org.example.data.dao.ConsLinPedido
import org.example.data.dao.ConsProducto
import org.example.data.dao.ConsUsuario
import org.example.data.DataBase
import org.example.data.dao.ConsPedido

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

    pe.eliminarPedido(preciototal, idusuario)

}