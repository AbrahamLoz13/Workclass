package com.example.workclass.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
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
import coil.compose.AsyncImage
import com.example.workclass.R


@Composable
fun AccountDetailCardComponent(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Imagen y estrella arriba
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Esto centra todo dentro del Column
        ) {
            AsyncImage(
                model = imageURL,
                contentDescription = "Account Logo",
                contentScale = ContentScale.Fit,
                error = painterResource(R.drawable.amogus),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                //.clip(RoundedCornerShape(12.dp)) // Opcional
            )
        }


        IconButton(onClick = onSaveClick) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Save as Favorite"
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    InfoRow(title = "Account", value = name)
    InfoRow(title = "Username", value = username, showIcon = true)
    InfoRow(title = "Password", value = password, showIcon = true) // Puedes usar un state para ocultar/revelar
    InfoRow(title = "Description", value = description)
}


@Composable
fun InfoRow(title: String, value: String, showIcon: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title:",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            modifier = Modifier.weight(2f)
        )
        if (showIcon) {
            IconButton(onClick = {
                // Acción: copiar al portapapeles o compartir
            }) {
                Icon(
                    imageVector = Icons.Default.Share, // Reemplaza por el ícono adecuado
                    contentDescription = "Action"
                )
            }
        }
    }
}