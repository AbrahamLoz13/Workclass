package com.example.workclass.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.viewmodel.AccountViewModel
import com.example.workclass.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    id: Int? = null,
    viewModel: AccountViewModel = viewModel()
) {

    // Estado para almacenar la cuenta
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    // Efecto lanzado para obtener los datos de la cuenta si el id no es nulo
    LaunchedEffect(id) {
        if (id != null) {
            viewModel.getAccount(id) { response ->
                if (response.isSuccessful) {
                    // Si la respuesta es exitosa, asignamos la cuenta obtenida
                    response.body()?.let {
                        account.value = it
                    }
                } else {
                    Log.d("debug", "Error getting account") // Log en caso de error
                }
            }
        }
    }

    // Contenedor principal para la pantalla
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background) // Fondo de la pantalla
            .padding(10.dp) // Espaciado
            .fillMaxSize() // Tamaño completo
    ) {
        // Componente superior con el título y navegación
        TopBarComponent("Add account", navController, "manage_account_screen")

        // Campo para el nombre de la cuenta
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(), // Ocupa todo el ancho disponible
            value = account.value.name, // Valor actual del nombre
            maxLines = 1, // Número máximo de líneas
            label = {
                Text(
                    "Account Name ",
                    color = MaterialTheme.colorScheme.onBackground // Asegura que el texto sea visible en ambos modos
                )
            }, // Etiqueta del campo
            onValueChange = { account.value = account.value.copy(name = it) } // Actualiza el nombre al cambiar
        )

        // Campo para el nombre de usuario de la cuenta
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = {
                Text(
                    "Account Username ",
                    color = MaterialTheme.colorScheme.onBackground // Asegura que el texto sea visible en ambos modos
                )
            },
            onValueChange = { account.value = account.value.copy(username = it) }
        )

        // Campo para la contraseña de la cuenta
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = {
                Text(
                    "Account Password ",
                    color = MaterialTheme.colorScheme.onBackground // Asegura que el texto sea visible en ambos modos
                )
            },
            onValueChange = { account.value = account.value.copy(password = it) }
        )

        // Campo para la descripción de la cuenta
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = {
                Text(
                    "Account Description ",
                    color = MaterialTheme.colorScheme.onBackground // Asegura que el texto sea visible en ambos modos
                )
            },
            onValueChange = { account.value = account.value.copy(description = it) }
        )

        // Botón para guardar o actualizar la cuenta
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho
                .padding(0.dp, 10.dp), // Espaciado vertical
            onClick = {
                if (id == null) {
                    // Si el id es nulo, estamos creando una nueva cuenta
                    TryAccount(
                        account.value.name,
                        account.value.username,
                        account.value.password,
                        account.value.description,
                        viewModel,
                        context
                    )
                } else {
                    // Si el id no es nulo, estamos actualizando una cuenta existente
                    // Validamos que los campos no estén vacíos antes de actualizar
                    if (account.value.name.isEmpty() || account.value.username.isEmpty() || account.value.password.isEmpty() || account.value.description.isEmpty()) {
                        // Si algún campo está vacío, mostramos un mensaje
                        Toast.makeText(context, "Error, please fill all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        // Si todos los campos están completos, actualizamos la cuenta
                        viewModel.updateAccount(id, account.value) { response ->
                            Toast.makeText(context, "Account updated successfully", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        ) {
            // Texto del botón dependiendo de si es creación o actualización
            Text(if (id == null) "Save Account" else "Update Account")
        }

        // Botón para eliminar la cuenta
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho
                .padding(0.dp, 10.dp), // Espaciado vertical
            onClick = {
                // Confirmamos la eliminación de la cuenta
                if (id != null) {
                    viewModel.deleteAccount(id) { response ->
                        Toast.makeText(context, "Account deleted successfully", Toast.LENGTH_SHORT).show()
                        navController.popBackStack() // Volver a la pantalla anterior
                    }

                }

            }


        )
        {
            Text("Delete account")
        }

    }
}

// Función para crear una cuenta si todos los campos son válidos
fun TryAccount(name: String, username: String, password: String, description: String, viewModel: AccountViewModel, context: Context) {
    // Validación de los campos antes de crear la cuenta
    if (name == "" || username == "" || password == "" || description == "") {
        // Muestra un mensaje si algún campo está vacío
        Toast.makeText(
            context,
            "Error, please add all data",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        // Si los datos son válidos, se crea la cuenta
        val addAccount = AccountModel(0, name, username, password, description)
        viewModel.createAccount(addAccount) { jsonResponse ->
            // Se maneja la respuesta después de la creación
            val createStatus = jsonResponse?.get("addAccount")?.asString
            // Muestra un mensaje de éxito
            Toast.makeText(
                context,
                "Account added successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
