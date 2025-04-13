package com.example.workclass.data.model

import androidx.compose.ui.graphics.vector.ImageVector

// Esta clase representa un modelo de menú, utilizado probablemente en una interfaz de usuario.
// Almacena la información relacionada con cada opción del menú, como el título, la opción, y el icono.
data class MenuModel(
    val id: Int,                // Identificador único para cada opción del menú.
    val title: String,          // Título de la opción en el menú (texto visible).
    val option: String,         // Descripción o clave de la opción.
    val icon: ImageVector       // Icono asociado con la opción del menú (utiliza ImageVector para representar imágenes vectoriales).
)
