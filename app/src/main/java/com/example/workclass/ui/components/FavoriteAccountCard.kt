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

@Composable
fun FavoriteAccountCard(id:Int,
                        name:String,
                        username: String,
                        password:String,
                        description:String,
                        imageURL:String,
                        onDeleteClick: ()-> Unit
){
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp
        )){
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
            Text(
                text = name,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = {onDeleteClick()}) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Account")
            }

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Username",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = username,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Password",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = password,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Description:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
    }
}