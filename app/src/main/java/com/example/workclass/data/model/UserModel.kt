package com.example.workclass.data.model

// Esta clase representa un modelo de usuario, utilizado para almacenar la información de un usuario en la aplicación.
data class UserModel(
    var id: Int = 0,              // Identificador único del usuario (valor por defecto 0).
    var name: String = "",        // Nombre del usuario (valor por defecto una cadena vacía).
    var username: String = "",    // Nombre de usuario utilizado para la autenticación (valor por defecto una cadena vacía).
    var password: String = ""     // Contraseña del usuario (valor por defecto una cadena vacía).
)
