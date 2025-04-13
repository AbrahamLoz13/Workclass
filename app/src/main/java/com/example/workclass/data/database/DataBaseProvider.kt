package com.example.workclass.data.database

import android.content.Context
import androidx.room.Room

// Este objeto proporciona una instancia de la base de datos de forma segura y única.
// Se asegura de que solo haya una instancia de la base de datos en toda la aplicación (patrón Singleton).
object DatabaseProvider {

    // Variable que mantiene la instancia de la base de datos. Es inicializada solo una vez.
    private var instance: AppDatabase? = null

    // Esta función devuelve la instancia de la base de datos.
    // Si la instancia no ha sido creada, la crea de manera sincronizada.
    // Utiliza Room para construir la base de datos.
    fun getDatabase(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            // Si la instancia no existe, se crea una nueva base de datos utilizando Room.
            val db = Room.databaseBuilder(
                context.applicationContext,  // Contexto de la aplicación para evitar fugas de memoria.
                AppDatabase::class.java,    // Clase de la base de datos que Room debe usar.
                "app-db"                    // Nombre del archivo de la base de datos.
            ).build()

            // Asigna la nueva instancia de la base de datos a la variable 'instance'.
            instance = db

            // Retorna la instancia de la base de datos.
            db
        }
    }
}
