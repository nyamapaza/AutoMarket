package nilber.apaza.my_final.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nilber.apaza.my_final.R


@Composable
fun LoginScreen(navigateToLogin: () -> Unit,
                navigateToRegister: () -> Unit){
    Fondo{
        Alinear {
            Titulo(text = "Bienvenidos a AutoMarket")
            Imagenes(id = R.drawable.foto)
            SpacerH(height = 30.dp)
            Sombra(
                modifier = Modifier
                    .size(width = 350.dp, height = 160.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color.Gray)
            ) {
                Descri(
                    text = "Te ofrecemos una cantidad de autos usados verificados." +
                            " Puede encontrar lo que buscas según el año, y precio. Además," +
                            " puedes publicar tu propio auto en venta.",
                    color = Color.White
                )
            }
            SpacerH(height = 20.dp)
            Boton(
                text = "INICIAR SECCIÓN",
                onClick = { navigateToLogin() },
            )
            SpacerH(height = 20.dp)
            Boton(
                text = "REGISTRARSE",
                onClick = { navigateToRegister() },
            )
        }
    }
}