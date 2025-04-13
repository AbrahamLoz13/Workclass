package com.example.workclass.data.model

import androidx.compose.ui.graphics.vector.ImageVector

// Esta clase representa un modelo para una tarjeta de publicación o post.
// Almacena la información necesaria para mostrar una tarjeta de contenido en la interfaz.
data class PostCardModel(
    val id: Int,             // Identificador único para cada tarjeta de publicación.
    val title: String,       // Título de la publicación o contenido.
    val text: String,        // Texto o descripción de la publicación.
    val iamge: Int           // Recurso de imagen asociado a la tarjeta, representado por un identificador entero (probablemente el ID de un recurso).
)
