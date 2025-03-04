package com.example.workclass.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.workclass.R

@Composable
fun DarkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Color.Black,
            surface = Color.DarkGray,
            onSurface = Color.White
        ),
        content = content
    )
}

data class User(val name: String, val profilePic: Int, val postImage: Int)
val users = listOf(
    User("AbrahamLozano", R.drawable.img, R.drawable.tamales),
    User("Mabel_Ruiz", R.drawable.foto, R.drawable.semestre),
    User("Georgia_Torres", R.drawable.fotohistoria_verde, R.drawable.gato),
    User("Manuel_Pérez", R.drawable.foto3, R.drawable.semestre),
    User("Sofía_Gómez", R.drawable.img, R.drawable.tamales),
    User("Carlos_Ramírez", R.drawable.foto3, R.drawable.gato)
)

@Composable
fun InstagramHome(navController: NavHostController) {
    Scaffold(
        topBar = { InstagramTopBar() },
        bottomBar = { InstagramBottomBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            item { InstagramStories() }
            items(users) { user ->
                InstagramPost(user)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = { Text(text = "Instagram", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)) },
        actions = {
            IconButton(onClick = { /* Mensajes */ }) {
                Icon(Icons.Default.Email, contentDescription = "Mensajes", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
    )
}

@Composable
fun InstagramBottomBar() {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Inicio */ }) {
                Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White)
            }
            IconButton(onClick = { /* Buscar */ }) {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
            }
            IconButton(onClick = { /* Agregar */ }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar", tint = Color.White)
            }
            IconButton(onClick = { /* Reels */ }) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Reels", tint = Color.White)
            }
            IconButton(onClick = { /* Perfil */ }) {
                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
            }
        }
    }
}

@Composable
fun InstagramStories() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(users) { user ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = user.profilePic),
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = user.name, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Composable
fun InstagramPost(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = user.profilePic),
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = user.name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Más opciones */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Más", tint = Color.White)
            }
        }

        Image(
            painter = painterResource(id = user.postImage),
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Like */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Like", tint = Color.White)
            }
            IconButton(onClick = { /* Comentar */ }) {
                Icon(Icons.Default.MailOutline, contentDescription = "Comentar", tint = Color.White)
            }
            IconButton(onClick = { /* Compartir */ }) {
                Icon(Icons.Default.Send, contentDescription = "Compartir", tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Guardar */ }) {
                Icon(Icons.Default.Email, contentDescription = "Guardar", tint = Color.White)
            }
        }
        Text(
            text = "Liked by ${users.random().name} and others",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = "${user.name}: This is an Instagram clone!",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}
@Preview
@Composable
fun InstagramPreview() {
    val navController = rememberNavController()
    InstagramHome(navController = navController)
}
