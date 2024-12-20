package nilber.apaza.my_final.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import nilber.apaza.my_final.ViewModel.VehiculoViewModel

@Composable
fun ListaVehiculosScreen(viewModel: VehiculoViewModel, onVehiculoSeleccionado: (Int) -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.cargarVehiculos {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
        println("Vehiculos cargados: ${viewModel.vehiculos.value}")
    }
//viewModel.vehiculos.value
    LazyColumn {
        items(viewModel.vehiculos.value) { vehiculo ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onVehiculoSeleccionado(vehiculo.id) }
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = rememberImagePainter(vehiculo.foto),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("${vehiculo.marca} - ${vehiculo.modelo}", fontWeight = FontWeight.Bold)
                        Text("Precio: ${vehiculo.precio}")
                        Text("${vehiculo.anio} | ${vehiculo.kilometraje} km")
                    }
                }
            }
        }
    }
}

