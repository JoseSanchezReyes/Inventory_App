package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticulosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(articulos: Articulos)

    @Update
    suspend fun update(articulos: Articulos)

    @Delete
    suspend fun delete(articulos: Articulos)

    //Consultar un articulo seleccionado
    @Query( "SELECT * FROM articulos WHERE id = :id" )
    fun getArticulo(id: Int): Flow<Articulos>

    //Consultar toda la lista de articulos
    @Query( "SELECT * FROM articulos ORDER BY nombre ASC" )
    fun getArticulos(): Flow<List<Articulos>>

}