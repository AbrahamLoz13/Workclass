package com.example.workclass.data.network

import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.model.UserModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

// Esta interfaz define los métodos para interactuar con la API usando Retrofit.
// Cada función está asociada con un tipo de solicitud HTTP y su respectiva ruta en el servidor.
interface ApiService {

    // Función para realizar el login de un usuario.
    // Recibe un objeto UserModel como cuerpo de la solicitud y devuelve una respuesta JSON.
    @POST("user")
    suspend fun login (@Body user: UserModel): Response<JsonObject>

    // Función para obtener todas las cuentas desde la API.
    // Realiza una solicitud GET y devuelve una lista de objetos AccountModel.
    @GET("service")
    suspend fun getAccounts(): Response<List<AccountModel>>

    // Función para obtener una cuenta específica por su ID.
    // La ruta incluye el ID de la cuenta, que se pasa como parámetro en la URL.
    @GET("service/{id}")
    suspend fun getAccount(@Path("id") id: Int): Response<AccountModel>

    // Función para agregar una nueva cuenta.
    // Recibe un objeto AccountModel en el cuerpo de la solicitud y devuelve una respuesta JSON.
    @POST("service")
    suspend fun addAccount(@Body service: AccountModel): Response<JsonObject>

    // Función para actualizar una cuenta existente.
    // Recibe el ID de la cuenta a actualizar y un objeto AccountModel con los nuevos datos.
    @PUT("service/{id}")
    suspend fun updateAccount(@Path("id") id: Int, @Body service: AccountModel): Response<JsonObject>

    // Función para eliminar una cuenta por su ID.
    // Realiza una solicitud DELETE para eliminar la cuenta especificada.
    @DELETE("service/{id}")
    suspend fun deleteAccount(@Path("id") id: Int): Response<JsonObject>
}
