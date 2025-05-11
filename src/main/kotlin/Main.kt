package org.example

import org.example.data.DataBase

fun main(){

    DataBase.getConnection()
    DataBase.initDatabase()
    DataBase.updateDatabase()

}