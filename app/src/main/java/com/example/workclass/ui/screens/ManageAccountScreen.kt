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
import com.example.workclass.data.model.UserModel
import com.example.workclass.data.viewmodel.AccountViewModel
import com.example.workclass.data.viewmodel.UserViewModel
import com.example.workclass.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    id: Int? = null,
    viewModel: AccountViewModel = viewModel()
){

    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    LaunchedEffect(id) {
        if (id != null) {
            viewModel.getAccount(id) { response ->
                if (response.isSuccessful) {
                    response.body()?.let {
                        account.value = it
                    }
                } else {
                    Log.d("debug", "Error al obtener cuenta")
                }
            }
        }
    }


    Column (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ){
        TopBarComponent("Add account",navController,"manage_account_screen")

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            label = {"Account Name "},
            onValueChange = {account.value = account.value.copy(name = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = {"Account Username "},
            onValueChange = {account.value = account.value.copy(username = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = {"Account Password "},
            onValueChange = {account.value = account.value.copy(password = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = {"Account Description "},
            onValueChange = {account.value = account.value.copy(description = it)}
        )
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,10.dp),
            onClick = {
                if (id == null) {
                    // Crear
                    TryAccount(
                        account.value.name,
                        account.value.username,
                        account.value.password,
                        account.value.description,
                        viewModel,
                        context,

                        )
                } else {
                    // Actualizar
                    viewModel.updateAccount(id, account.value) { response ->
                        Toast.makeText(context, "Cuenta actualizada correctamente", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        ) {
            Text(if (id == null) "Guardar cuenta" else "Actualizar cuenta")
        }

    }
}

fun TryAccount(name:String,username:String,password:String,description:String,viewModel: AccountViewModel, context: Context) {
    if (name == "" || username == "" || password == "" || description == "") {
        Toast.makeText(
            context,
            "Error agregue todos los datos ",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        val add_Account = AccountModel(0, name, username, password, description)
        viewModel.createAccount(add_Account) { jsonResponse ->
            val CreateStatus = jsonResponse?.get("addAccount")?.asString
            Toast.makeText(
                context,
                "Se agrego la cuenta de forma exitosa",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}