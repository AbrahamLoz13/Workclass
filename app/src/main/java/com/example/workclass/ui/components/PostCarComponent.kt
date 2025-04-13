package com.example.workclass.ui.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workclass.R


// Composable que crea una tarjeta con un título, una imagen y un texto
@Composable
fun PostCardComponent(
    id: Int,  // ID de la publicación (aunque no se usa en este caso)
    title: String,  // Título de la publicación
    text: String,  // Texto o contenido de la publicación
    image: Int  // Recurso de la imagen que se mostrará en la tarjeta
) {
    // Tarjeta con fondo gris claro y padding
    Card(
        modifier = Modifier
            .background(Color.LightGray)  // Fondo gris claro
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho disponible
            .padding(5.dp)  // Padding interno de 5dp
    ) {
        // Título de la publicación
        Text(
            text = title,  // El título que se mostrará
            fontSize = 24.sp,  // Tamaño de la fuente del título
            fontWeight = FontWeight.Bold,  // El título está en negrita
            modifier = Modifier
                .padding(10.dp)  // Padding alrededor del texto
        )

        // Imagen asociada con la publicación
        Image(
            modifier = Modifier
                .fillMaxWidth()  // La imagen ocupa todo el ancho de la tarjeta
                .height(200.dp),  // La altura de la imagen es de 200dp
            painter = painterResource(image),  // Recurso de la imagen
            contentDescription = "Android Logo",  // Descripción de la imagen
            contentScale = ContentScale.Crop  // La imagen se recorta para ajustarse al tamaño
        )

        // Texto de la publicación
        Text(
            text = text,  // El texto de la publicación
            textAlign = TextAlign.Justify,  // Alineación justificada del texto
            lineHeight = 10.sp,  // Altura de la línea para el texto
            modifier = Modifier.padding(10.dp)  // Padding alrededor del texto
        )
    }
}

// Composable que crea una tarjeta compacta con un título, imagen y texto en una fila
@Composable
fun PostCardCompactComponent(
    id: Int,  // ID de la publicación (aunque no se usa en este caso)
    title: String,  // Título de la publicación
    text: String,  // Texto o contenido de la publicación
    image: Int  // Recurso de la imagen que se mostrará en la tarjeta
) {
    // Tarjeta compacta con fondo gris claro y padding
    Card(
        modifier = Modifier
            .background(Color.LightGray)  // Fondo gris claro
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho disponible
            .padding(5.dp)  // Padding interno de 5dp
    ) {
        // Fila para colocar la imagen y el contenido en una fila
        Row() {
            // Imagen de la publicación con dimensiones fijas
            Image(
                modifier = Modifier
                    .width(80.dp)  // Ancho de la imagen es de 80dp
                    .height(100.dp),  // La altura de la imagen es de 100dp
                painter = painterResource(image),  // Recurso de la imagen
                contentDescription = "Android Logo",  // Descripción de la imagen
                contentScale = ContentScale.Crop  // La imagen se recorta para ajustarse
            )

            // Columna que contiene el título y el texto
            Column() {
                // Título de la publicación
                Text(
                    text = title,  // El título que se mostrará
                    fontSize = 12.sp,  // Tamaño de la fuente del título (más pequeño)
                    fontWeight = FontWeight.Bold,  // El título está en negrita
                    modifier = Modifier
                        .padding(5.dp)  // Padding alrededor del texto
                )

                // Texto de la publicación
                Text(
                    text = text,  // El texto de la publicación
                    textAlign = TextAlign.Justify,  // Alineación justificada del texto
                    lineHeight = 14.sp,  // Altura de la línea para el texto
                    fontSize = 10.sp,  // Tamaño de la fuente (más pequeño)
                    modifier = Modifier.padding(10.dp)  // Padding alrededor del texto
                )
            }
        }
    }
}
