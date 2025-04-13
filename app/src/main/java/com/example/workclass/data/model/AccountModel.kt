package com.example.workclass.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Esta es una clase de modelo que representa una cuenta.
// No está directamente relacionada con la base de datos.
data class AccountModel(
    var id: Int = 0,                  // Identificador único de la cuenta.
    var name: String = "",            // Nombre de la cuenta.
    var username: String = "",        // Nombre de usuario.
    var password: String = "",        // Contraseña de la cuenta.
    var description: String = "",     // Descripción de la cuenta.
    var imageURL: String? = null      // URL de la imagen asociada a la cuenta (opcional).
)

// Esta es una clase de entidad que está relacionada con la base de datos.
// Room usará esta clase para crear y manipular la tabla correspondiente.
@Entity
data class AccountEntity(
    @PrimaryKey val id: Int,                     // Definimos la clave primaria para la entidad.
    @ColumnInfo(name = "name") val name: String,  // Definimos el nombre de la columna "name".
    @ColumnInfo(name = "username") val username: String,  // Nombre de usuario en la columna "username".
    @ColumnInfo(name = "password") val password: String,  // Contraseña en la columna "password".
    @ColumnInfo(name = "description") val description: String,  // Descripción en la columna "description".
    @ColumnInfo(name = "imageURL") val imageURL: String?  // URL de la imagen en la columna "imageURL".
)

// Función de extensión para convertir un AccountModel en AccountEntity.
// Esta función es útil para convertir los datos del modelo a la entidad de la base de datos.
fun AccountModel.toAccountEntity(): AccountEntity {
    return AccountEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        password = this.password,
        description = this.description,
        imageURL = this.imageURL
    )
}
