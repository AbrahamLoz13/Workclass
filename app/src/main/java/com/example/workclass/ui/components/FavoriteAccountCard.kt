package com.example.workclass.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Delete
import coil.compose.AsyncImage
import com.example.workclass.R

// Composable para mostrar una tarjeta con los detalles de una cuenta favorita
@Composable
fun FavoriteAccountCard(
    id: Int,  // ID de la cuenta (aunque no se usa en este caso)
    name: String,  // Nombre de la cuenta
    username: String,  // Nombre de usuario de la cuenta
    password: String,  // Contraseña de la cuenta
    description: String,  // Descripción de la cuenta
    imageURL: String,  // URL de la imagen de la cuenta
    onDeleteClick: () -> Unit  // Acción que se ejecutará al hacer clic en el botón de eliminar
) {
    // Card que contiene toda la información de la cuenta
    Card(
        modifier = Modifier
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho disponible
            .padding(10.dp)  // Añade un padding alrededor de la tarjeta
    ) {
        // Fila que contiene la imagen de la cuenta, el nombre y el botón de eliminar
        Row(
            modifier = Modifier
                .fillMaxWidth()  // La fila ocupa todo el ancho disponible
                .height(100.dp)  // La altura de la fila es 100dp
                .padding(5.dp),  // Padding interno
            horizontalArrangement = Arrangement.SpaceBetween,  // Espaciado entre los elementos
            verticalAlignment = Alignment.CenterVertically  // Alineación vertical centrada
        ) {
            // Imagen de la cuenta
            AsyncImage(
                model = imageURL,  // URL de la imagen que se cargará
                contentDescription = "Account Logo",  // Descripción de la imagen
                contentScale = ContentScale.Fit,  // Escalado de la imagen para ajustarse
                error = painterResource(R.drawable.amogus),  // Imagen por defecto en caso de error
                modifier = Modifier
                    .width(100.dp)  // Ancho de la imagen
                    .height(100.dp)  // Alto de la imagen
                // .clip(RoundedCornerShape(12.dp))  // Esto se puede usar para bordes redondeados en la imagen
            )
            // Nombre de la cuenta
            Text(
                text = name,  // El nombre que se mostrará
                modifier = Modifier.weight(1f),  // Hace que el texto ocupe el espacio restante
                fontWeight = FontWeight.Bold  // Establece el peso de la fuente a negrita
            )

            // Botón para eliminar la cuenta
            IconButton(onClick = { onDeleteClick() }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Account")  // Icono de eliminar
            }
        }

        // Fila que muestra el nombre de usuario
        Row(
            modifier = Modifier
                .fillMaxWidth()  // La fila ocupa todo el ancho disponible
                .padding(5.dp),  // Padding interno
            horizontalArrangement = Arrangement.SpaceBetween,  // Espaciado entre los elementos
            verticalAlignment = Alignment.CenterVertically  // Alineación vertical centrada
        ) {
            // Texto "Username"
            Text(
                text = "Username",  // Texto estático "Username"
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
            // Nombre de usuario de la cuenta
            Text(
                text = username,  // El nombre de usuario
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
        }

        // Fila que muestra la contraseña
        Row(
            modifier = Modifier
                .fillMaxWidth()  // La fila ocupa todo el ancho disponible
                .padding(5.dp),  // Padding interno
            horizontalArrangement = Arrangement.SpaceBetween,  // Espaciado entre los elementos
            verticalAlignment = Alignment.CenterVertically  // Alineación vertical centrada
        ) {
            // Texto "Password"
            Text(
                text = "Password",  // Texto estático "Password"
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
            // Contraseña de la cuenta
            Text(
                text = password,  // La contraseña
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
        }

        // Fila que muestra la descripción
        Row(
            modifier = Modifier
                .fillMaxWidth()  // La fila ocupa todo el ancho disponible
                .padding(5.dp),  // Padding interno
            horizontalArrangement = Arrangement.SpaceBetween,  // Espaciado entre los elementos
            verticalAlignment = Alignment.CenterVertically  // Alineación vertical centrada
        ) {
            // Texto "Description:"
            Text(
                text = "Description:",  // Texto estático "Description:"
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
            // Descripción de la cuenta
            Text(
                text = description,  // La descripción de la cuenta
                fontSize = 20.sp,  // Tamaño de la fuente
                fontWeight = FontWeight.Medium  // Peso de la fuente
            )
        }
    }
}
