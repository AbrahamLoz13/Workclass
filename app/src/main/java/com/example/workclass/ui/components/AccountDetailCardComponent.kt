package com.example.workclass.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.workclass.R

@Composable
fun AccountDetailCardComponent(
    id:Int,
    name:String,
    username: String,
    password: String,
    imageURL:String?,
    description: String,
    onSaveClick:()->Unit
){
    Column (){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(10.dp),
            Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                model = imageURL,
                error = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Account Logo",
                contentScale = ContentScale.FillBounds
            )
        }
        IconButton(
            modifier = Modifier
                .padding(20.dp,0.dp,0.dp,0.dp),
            onClick= {
                onSaveClick()
            }){
            Icon (
                imageVector= Icons.Filled.Star,
                contentDescription = "Logo"
            )
        }


    }
}