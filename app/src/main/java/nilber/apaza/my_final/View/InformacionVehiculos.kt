package nilber.apaza.my_final.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import nilber.apaza.my_final.ViewModel.VehiculoViewModel

@Composable
fun DetalleVehiculoScreen(viewModel: VehiculoViewModel, vehiculoId: Int, onBack: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(vehiculoId) {
        viewModel.cargarVehiculoPorId(vehiculoId) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    viewModel.vehiculoSeleccionado.value?.let { vehiculo ->
        Column(modifier = Modifier.padding(16.dp)) {
            Text("${vehiculo.marca} ${vehiculo.modelo}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Precio: ${vehiculo.precio}", fontSize = 20.sp, color = Color.Gray)
            Text("${vehiculo.anio} | ${vehiculo.kilometraje} km | ${vehiculo.color}")
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = rememberImagePainter(vehiculo.foto),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Descripción", fontWeight = FontWeight.Bold)
            Text(vehiculo.descripcion)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Especificaciones Técnicas", fontWeight = FontWeight.Bold)
            Text("Combustible: ${vehiculo.combustible}")
            Text("Cilindrada: ${vehiculo.cilindrada} cc")
            Text("Potencia: ${vehiculo.potencia}")
            // Añade más detalles según el modelo
        }
    } ?: CircularProgressIndicator()
}
