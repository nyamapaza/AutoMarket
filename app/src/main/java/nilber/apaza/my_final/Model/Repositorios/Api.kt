package nilber.apaza.my_final.Model.Repositorios

import nilber.apaza.my_final.Model.models.Vehiculo


import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("vehiculos")
    suspend fun createVehiculo(@Body vehiculo: Vehiculo): Response<Vehiculo>

    @GET("vehiculos/{id}")
    suspend fun getVehiculoById(@Path("id") id: Int): Response<Vehiculo>

    @GET("vehiculos")
    suspend fun getAllVehiculos(): Response<List<Vehiculo>>
}
