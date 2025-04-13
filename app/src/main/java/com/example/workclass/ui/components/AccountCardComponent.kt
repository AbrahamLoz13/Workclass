package com.example.workclass.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.workclass.R

// Componente que muestra una tarjeta con la información de una cuenta de usuario
@Composable
fun AccountCardComponent(
    id: Int,                // ID de la cuenta
    name: String,           // Nombre del usuario
    username: String,       // Nombre de usuario
    imageURL: String,       // URL de la imagen del usuario
    onButtonClick: () -> Unit // Acción cuando se hace clic en el botón de más opciones
) {
    // Componente Card que contiene la estructura de la tarjeta
    Card(
        modifier = Modifier
            .fillMaxWidth()       // La tarjeta ocupará todo el ancho disponible
            .padding(3.dp)        // Espacio alrededor de la tarjeta
    ) {
        // Fila que contiene la imagen, el texto y el botón de opciones
        Row() {
            // Componente AsyncImage para cargar la imagen de la cuenta
            AsyncImage(
                modifier = Modifier
                    .width(80.dp)          // Ancho de la imagen
                    .height(80.dp)         // Alto de la imagen
                    .padding(10.dp),       // Espacio alrededor de la imagen
                model = imageURL,             // URL de la imagen a mostrar
                error = painterResource(R.drawable.amogus), // Imagen en caso de error
                contentDescription = "Account Logo", // Descripción de la imagen
                contentScale = ContentScale.FillBounds // Escala de la imagen
            )

            // Columna que contiene el nombre y el nombre de usuario
            Column {
                // Texto que muestra el nombre de la cuenta
                Text(
                    text = name,
                    fontSize = 18.sp,                    // Tamaño de fuente
                    fontWeight = FontWeight.Bold,        // Estilo de fuente en negrita
                    modifier = Modifier
                        .padding(2.dp, 8.dp, 0.dp, 0.dp)  // Espaciado alrededor del texto
                )

                // Texto que muestra el nombre de usuario
                Text(
                    text = username,
                    fontSize = 18.sp,                    // Tamaño de fuente
                    fontWeight = FontWeight.Bold,        // Estilo de fuente en negrita
                    modifier = Modifier
                        .padding(2.dp, 8.dp, 0.dp, 0.dp)  // Espaciado alrededor del texto
                )
            }

            // Fila que contiene el botón de más opciones (icono de tres puntos)
            Row(
                modifier = Modifier
                    .fillMaxWidth()  // Ancho completo de la fila
                    .height(80.dp),  // Altura de la fila
                horizontalArrangement = Arrangement.End, // Alineación horizontal a la derecha
                verticalAlignment = Alignment.CenterVertically // Alineación vertical al centro
            ) {
                // Botón de icono que muestra tres puntos verticales (más opciones)
                IconButton(
                    modifier = Modifier
                        .padding(20.dp, 0.dp, 0.dp, 0.dp), // Espacio alrededor del botón
                    onClick = { onButtonClick() }  // Acción al hacer clic en el botón
                ) {
                    // Icono de tres puntos
                    Icon(
                        Icons.Filled.MoreVert,  // Icono de tres puntos
                        contentDescription = "Icon" // Descripción del icono
                    )
                }
            }
        }
    }
}
