package com.example.workclass.data.dao

import android.accounts.Account
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workclass.data.model.AccountEntity

// Definimos la interfaz AccountDao que interactúa con la base de datos usando Room
@Dao
interface AccountDao {

    // Esta función obtiene todas las cuentas de la base de datos.
    // El resultado es una lista de objetos AccountEntity.
    @Query("SELECT * FROM AccountEntity")
    fun getAll(): List<AccountEntity>

    // Esta función inserta una nueva cuenta en la base de datos.
    // Si ya existe una cuenta con el mismo identificador, se reemplaza.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: AccountEntity)

    // Esta función elimina una cuenta de la base de datos.
    // El parámetro es la cuenta que se eliminará.
    @Delete()
    fun delete(account: AccountEntity)
}
