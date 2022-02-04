package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Articulos::class], version = 1, exportSchema = false)
abstract class ArticulosRoomDatabase : RoomDatabase() {

    //Metodo abstracto que muestra una instancia ArticulosDao
    abstract fun articulosDao(): ArticulosDao

    //usando el metodo singleton, ya que solo ocupamos una instancia de RoomDatabase
    companion object {
        @Volatile
        private var INSTANCE: ArticulosRoomDatabase? = null

        /**Usando el Room.databaseBuilder de Room para crear la BD articulos_database
         * solo si no existe, de lo contrario muestra la Bd existente
         */
        fun getDatabase( context: Context): ArticulosRoomDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticulosRoomDatabase::class.java,
                    "articulos_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}