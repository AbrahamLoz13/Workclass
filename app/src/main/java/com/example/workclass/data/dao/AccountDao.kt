package com.example.workclass.data.dao



import android.accounts.Account
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workclass.data.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getAll(): List<AccountEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: AccountEntity)

    @Delete()
    fun delete(account: AccountEntity)
}