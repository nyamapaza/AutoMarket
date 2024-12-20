package nilber.apaza.my_final.View.Formulario

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import nilber.apaza.my_final.ViewModel.VehiculoViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import nilber.apaza.my_final.Model.models.VehiculoLlamar

@Composable
fun ListaVehiculos(viewModel: VehiculoViewModel) {
    val vehiculos = remember { mutableStateOf<List<VehiculoLlamar>>(emptyList()) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.obtenerVehiculos({
            vehiculos.value = it
        }, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    LazyColumn {
        items(vehiculos.value) { vehiculo ->
            Text("${vehiculo.marca} ${vehiculo.modelo} - ${vehiculo.anio}")
        }
    }
}
