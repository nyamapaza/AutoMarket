package nilber.apaza.my_final.View.Formulario

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import nilber.apaza.my_final.Model.models.Vehiculo
import nilber.apaza.my_final.ViewModel.VehiculoViewModel
@Composable
fun FormularioVehiculo(viewModel: VehiculoViewModel/*, onNavigateToLista: () -> Unit*/) {
    val descripcion = remember { mutableStateOf("") }
    val marca = remember { mutableStateOf("") }
    val modelo = remember { mutableStateOf("") }
    val anio = remember { mutableStateOf("") }
    val kilometraje = remember { mutableStateOf("") }
    val color = remember { mutableStateOf("") }
    val numeroPlaca = remember { mutableStateOf("") }
    val numeroMotor = remember { mutableStateOf("") }
    val combustible = remember { mutableStateOf("") }
    val cilindrada = remember { mutableStateOf("") }
    val potencia = remember { mutableStateOf("") }
    val valvulas = remember { mutableStateOf("") }
    val motor = remember { mutableStateOf("") }
    val traccion = remember { mutableStateOf("") }
    val trasmision = remember { mutableStateOf("") }
    val largo = remember { mutableStateOf("") }
    val ancho = remember { mutableStateOf("") }
    val altura = remember { mutableStateOf("") }
    val peso = remember { mutableStateOf("") }
    val capacidadCarga = remember { mutableStateOf("") }
    val numeroTelefono = remember { mutableStateOf("") }
    val precio = remember { mutableStateOf("") }
    val foto = remember { mutableStateOf("") }
    // Añade más campos según el modelo

    val context = LocalContext.current

    Column() {
        TextField(value = descripcion.value, onValueChange = { descripcion.value = it }, label = { Text("Descripción") })
        TextField(value = marca.value, onValueChange = { marca.value = it }, label = { Text("Marca") })
        TextField(value = modelo.value, onValueChange = { modelo.value = it }, label = { Text("Modelo") })
        TextField(value = anio.value, onValueChange = { anio.value = it }, label = { Text("2024") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = kilometraje.value, onValueChange = { kilometraje.value = it }, label = { Text("2000000") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = numeroPlaca.value, onValueChange = {numeroPlaca.value=it},label={ Text("numero_placa")})
        TextField(value = numeroMotor.value, onValueChange = {numeroMotor.value=it},label={ Text("numero_motor")})
        TextField(value = combustible.value, onValueChange = {combustible.value=it},label={ Text("conbustible")})
        TextField(value = cilindrada.value, onValueChange = {cilindrada.value=it},label={ Text("16")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = potencia.value, onValueChange = {potencia.value=it},label={ Text("8")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = valvulas.value, onValueChange = {valvulas.value=it},label={ Text("15")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = motor.value, onValueChange = {motor.value=it},label={ Text("motor")})
        TextField(value = traccion.value, onValueChange = {traccion.value=it},label={ Text("traccion")})
        TextField(value = trasmision.value, onValueChange = {trasmision.value=it},label={ Text("trasmision")})
        TextField(value = largo.value, onValueChange = {largo.value=it},label={ Text("4.5")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = ancho.value, onValueChange = {ancho.value=it},label={ Text("3.5")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = altura.value, onValueChange = {altura.value=it},label={ Text("2.1")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = peso.value, onValueChange = {peso.value=it},label={ Text("3.5")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = capacidadCarga.value, onValueChange = {capacidadCarga.value=it},label={ Text("450")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = numeroTelefono.value, onValueChange = {numeroTelefono.value=it},label={ Text("950514248")})
        TextField(value = precio.value, onValueChange = {precio.value=it},label={ Text("20000")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = foto.value, onValueChange = {foto.value=it},label={ Text("foto (opcional)")})

        // Botón de enviar
        Button(onClick = {
            val vehiculo = Vehiculo(
                descripcion = descripcion.value,
                marca = marca.value,
                modelo = modelo.value,
                anio = anio.value.toInt(),
                kilometraje = kilometraje.value.toInt(),
                // Rellena el resto de los campos
                color = color.value,
                numeroPlaca = numeroPlaca.value,
                numeroMotor = numeroMotor.value,
                combustible = combustible.value,
                cilindrada = cilindrada.value.toInt(),
                potencia = potencia.value.toInt(),
                valvulas = valvulas.value.toInt(),
                motor = motor.value,
                traccion = traccion.value,
                transmision = trasmision.value,
                largo = largo.value.toDouble(),
                ancho = ancho.value.toDouble(),
                altura = altura.value.toDouble(),
                peso = peso.value.toDouble(),
                capacidadCarga = peso.value.toDouble(),
                numeroTelefono = numeroTelefono.value,
                foto = null,
                terminosCondiciones = true,
                precio = precio.value.toDouble()
            )
            viewModel.guardarVehiculo(vehiculo, {
                Toast.makeText(context, "Vehículo guardado", Toast.LENGTH_SHORT).show()
               // onNavigateToLista()
            }, {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }) {
            Text("Enviar")
        }
    }
}
