package com.example.workclass.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Composable que crea una barra superior (TopBar) con íconos de acción
@OptIn(ExperimentalMaterial3Api::class)  // Esta anotación se utiliza porque estamos utilizando componentes experimentales de la librería Material3
@Composable
fun TopBarComponent(
    title: String,  // Título que se mostrará en la barra superior
    navController: NavController,  // Controlador de navegación que se usa para navegar entre pantallas
    location: String  // Ubicación actual de la pantalla para determinar qué íconos mostrar
) {
    // Creamos la barra superior (TopAppBar)
    TopAppBar(
        title = { Text(title) },  // Muestra el título en la barra superior
        actions = {
            // Si la pantalla actual es "accounts_screen", mostramos botones de acción
            if (location == "accounts_screen") {
                // Botón para agregar una cuenta
                IconButton(onClick = { navController.navigate("manage_account_screen") }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Go to saved account")
                }
                // Botón para ver cuentas favoritas
                IconButton(onClick = { navController.navigate("favorite_accounts_screen") }) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Icon")
                }
            }
        }
    )
}
