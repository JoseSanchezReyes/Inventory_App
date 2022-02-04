package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

@Entity (tableName = "articulos")
data class Articulos(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo ("nombre") val nombreArticulo: String,
    @ColumnInfo ("precio") val precio: Double,
    @ColumnInfo ("cantidad") val cantidadArticulo: Int,
)

//Funcion de extencion para dar formato de moneda al precio
fun Articulos.getFormattedPrecio(): String = NumberFormat.getCurrencyInstance().format(precio)