package com.example.workclass.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workclass.data.model.UserModel
import com.example.workclass.data.network.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

// Esta clase es un ViewModel que se encarga de manejar la lógica de negocio relacionada con el inicio de sesión de un usuario.
// Realiza la llamada a la API de login utilizando Retrofit y maneja la respuesta.
class UserViewModel : ViewModel() {
    // Instancia de la API configurada previamente en RetrofitClient.
    val api = RetrofitClient.api

    // Función para hacer login a través de la API.
    // Recibe un objeto UserModel con los datos del usuario y un callback onResult para manejar la respuesta de la API.
    fun loginApi(user_model: UserModel, onResult: (JsonObject?) -> Unit) {
        viewModelScope.launch {
            try {
                // Realiza la llamada a la API para iniciar sesión con los datos del usuario.
                val response = api.login(user_model)

                // Si la respuesta es exitosa, obtiene el cuerpo de la respuesta y lo pasa al callback.
                if (response.isSuccessful) {
                    val jsonResponse = response.body()  // Obtiene el cuerpo de la respuesta JSON.
                    Log.d("debug", "${response.body()}")  // Muestra la respuesta en log para depuración.
                    onResult(jsonResponse)  // Llama al callback con la respuesta obtenida.
                } else {
                    // Si la respuesta es un error, lo muestra en log.
                    Log.d("debug", "Error: ${response.body()}")
                    onResult(null)  // Llama al callback con valor nulo en caso de error.
                }
            } catch (exception: Exception) {
                // Si ocurre un error en la llamada a la API, lo muestra en el log.
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(null)  // Llama al callback con valor nulo en caso de fallo.
            }
        }
    }
}
