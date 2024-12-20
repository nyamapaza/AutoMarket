package nilber.apaza.my_final.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nilber.apaza.my_final.Model.Repositorios.ApiService
import nilber.apaza.my_final.Model.models.Vehiculo
import nilber.apaza.my_final.Model.models.VehiculoLlamar

class VehiculoViewModel : ViewModel() {
    private val apiService = ApiService()

    val vehiculos = mutableStateOf<List<VehiculoLlamar>>(emptyList())
    val vehiculoSeleccionado = mutableStateOf<VehiculoLlamar?>(null)

    fun guardarVehiculo(vehiculo: Vehiculo, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.crearVehiculo(vehiculo)
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    fun obtenerVehiculos(onResult: (List<Vehiculo>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.obtenerVehiculos()
                if (response.isSuccessful) {
                    response.body()?.let {
                        onResult(it)
                    }
                } else {
                    onError("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    fun cargarVehiculos(onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.obtenerVehiculos()
                if (response.isSuccessful) {
                    vehiculos.value = response.body() ?: emptyList()
                } else {
                    onError("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    fun cargarVehiculoPorId(id: Int, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.obtenerVehiculo(id)
                if (response.isSuccessful) {
                    vehiculoSeleccionado.value = response.body()
                } else {
                    onError("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }
}