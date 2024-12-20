package nilber.apaza.my_final.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import coil.compose.rememberImagePainter
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sombra(
    modifier: Modifier = Modifier, // Mantenemos el Modifier como parámetro
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier // Aplicamos correctamente el Modifier pasado como argumento
    ) {
        content() // Contenido del Box
    }
}
@Composable
fun Alinear(alinear: @Composable () -> Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .width(360.dp)
            .height(800.dp)
            .padding(top = 20.dp)){
        alinear()
    }
}
@Composable
fun Fondo(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xC72080F5))
            .padding(30.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        content() // Se muestra el contenido que se pasa como parámetro
    }
}

@Composable
fun FkormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text // Añadimos un parámetro para el tipo de teclado
) {
    var text by remember { mutableStateOf(value) } // Inicializa el estado del campo con el valor pasado

    // Actualiza el estado local cuando cambia el valor
    LaunchedEffect(value) {
        text = value // Sincroniza el estado local con el valor prop
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        // El Text ocupará la primera mitad del espacio
        Text(
            text = label,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )

        // El BasicTextField ocupará la otra mitad del espacio
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onValueChange(it) // Llamamos a onValueChange cuando el valor cambia
            },
            modifier = Modifier
                .weight(1f)
                .border(1.dp, color = Color.Black)
                .padding(4.dp)
                .height(25.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
    }
}


@Composable
fun Boton(
    text: String,
    onClick: () -> Unit,
    width: Dp = 233.dp,
    height: Dp = 37.dp,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}/*
@Composable
fun CarItem(car: Vehiculo) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            // Imagen (placeholder si no hay foto)
            val imageUrl = car.foto ?: "https://via.placeholder.com/150"
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = "Car Image",
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Columna con la información del carro
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "${car.marca} - ${car.modelo} (${car.anio})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text("Descripción: ${car.descripcion}", fontSize = 12.sp)
                Text("Color: ${car.color} | Combustible: ${car.combustible}", fontSize = 12.sp)
                Text("Kilometraje: ${car.kilometraje} Km", fontSize = 12.sp)
                Text("Transmisión: ${car.transmision} | Tracción: ${car.traccion}", fontSize = 12.sp)
                Text("Motor: ${car.motor} (${car.cilindrada}L, ${car.potencia} HP)", fontSize = 12.sp)
                Text("Teléfono: ${car.telefono}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
*/
@Composable
fun ImagenLogo(it: Int){
    Image(
        painter = painterResource(id = it),
        contentDescription = "Logo",
        modifier = Modifier
            .size(90.dp),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun Descri(text: String, color: Color = Color.White) { // Valor por defecto: blanco
    Text(
        text = text,          // Cadena de texto
        color = color,        // Color del texto
        fontSize = 20.sp,     // Tamaño de la fuente
        textAlign = TextAlign.Justify, // Alineación opcional
        modifier = Modifier.padding(10.dp)
    )
}
@Composable
fun SpacerH(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}
@Composable
fun Titulo(text:String){
    Text(
        text =text,
        fontSize = 30.sp,
        fontWeight = FontWeight.Medium,
        color = Color.White,
        textAlign = TextAlign.Center,
    )
}
@Composable
fun Imagenes(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Imagen del Carro",
        modifier = Modifier
            .size(width = 350.dp, height = 200.dp)
            .padding(top = 10.dp),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun EspLlenar(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = ""
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .padding(0.dp)
    )
}

@Composable
fun Iconos(icon: ImageVector, // Ícono que será usado
             contentDescription: String, // Descripción accesible
             onClick: () -> Unit, // Acción al presionar
             tint: Color = Color.Black, // Color del ícono
             size: Dp = 35.dp // Tamaño del ícono
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

@Composable
fun CheckBox(text: String){
    Row( verticalAlignment = Alignment.CenterVertically) {
    Checkbox(
        checked = false,
        onCheckedChange = {}
    )
    Text(text = text, fontSize = 20.sp)
}
}
@Composable
fun SpaceW(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}
/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavBar() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) { padding ->
        Content(padding)
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color(0xFF5D9CEC),
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* Acción al presionar */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atrás",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }

            Text(
                text = "AutoMarket",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { /* Acción al presionar */ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Configuración",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(backgroundColor = Color(0xFF5D9CEC)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Primer IconButton
            IconButton(onClick = { /* Acción */ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú",
                    tint = Color.White
                )
            }

            // Botón de Buscar
            Button(
                onClick = { /* Acción */ },
                modifier = Modifier
                    .height(40.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text("Buscar")
            }

            // Segundo IconButton
            IconButton(onClick = { /* Acción */ }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorito",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
fun Content(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(5) { // Se repite 5 veces para mostrar varias tarjetas

        }
    }
}*/