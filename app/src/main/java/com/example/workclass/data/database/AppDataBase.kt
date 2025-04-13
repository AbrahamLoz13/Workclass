package com.example.workclass.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workclass.data.dao.AccountDao
import com.example.workclass.data.model.AccountEntity

// Definimos la clase AppDatabase que extiende RoomDatabase.
// Esta clase representa la base de datos de Room en la aplicación.
@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    // Esta función devuelve una instancia del DAO (Data Access Object) para las cuentas.
    // El DAO proporciona los métodos de acceso a la base de datos.
    abstract fun accountDao(): AccountDao
}
