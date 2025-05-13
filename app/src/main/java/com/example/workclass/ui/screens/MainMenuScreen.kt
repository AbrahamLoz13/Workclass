package com.example.workclass.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
@Composable
fun MainMenuScreen(navController: NavHostController){
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
    ) {
        //Botón que sirve para navegar a HomeScreen
        Button(onClick = {navController.navigate("Home_Screen")}
        ) {
            Text("GO TO HOME SCREEN")
        }
        Button(onClick = {navController.navigate("Test_Screen")}
        ) {
            Text("GO TO TEST SCREEN")
        }
        Button(onClick = {navController.navigate("Instagram_Screen")}
        ) {
            Text("GO TO INSTAGRAM CLONE")
        }
        Button(onClick = {navController.navigate("Components_Screen")}
        ) {
            Text("GO TO COMPONENTS SCREEN")
        }
        Button(onClick = {navController.navigate("Login_screen")}
        ) {
            Text("GO TO LOGIN SCREEN")
        }
        Button(onClick = {navController.navigate("camara")}
        ) {
            Text("GO TO API CAMERA")
        }

    }
}

