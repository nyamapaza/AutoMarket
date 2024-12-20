package nilber.apaza.my_final.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nilber.apaza.my_final.R


@Composable
fun AutoMarket(navigateCom:()->Unit,navigateVen:()->Unit){
    Fondo {
        Alinear {
            Row(modifier = Modifier
                .padding( 20.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                ImagenLogo(it = R.drawable.foto)
                SpaceW(width = 20.dp)
                Titulo(text = "AutoMarket")
            }
            Sombra (
                modifier = Modifier
                    .size(width = 350.dp, height = 380.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color.Gray)
                    .padding(10.dp)
            ){
                Descri(text =  "La app no se responsabiliza por fraudes, engaños o estafas que" +
                        " puedan ocurrir entre los usuarios. Cada comprador y vendedor es responsable " +
                        "de verificar la autenticidad al realizar transacciones de manera segura. La app " +
                        "no interviene en los acuerdos, pagos o interacciones fuera de la plataforma. " +
                        "Al usar esta app, aceptas que cualquier riesgo corre por tu cuenta.",
                )
            }
            CheckBox(text = "Terminos y Condiciones")
            Boton(text = "COMPRADOR", onClick = {navigateCom()})
            SpacerH(height = 20.dp)
            Boton(text = "VENDEDOR", onClick = {navigateVen()})
        }
    }
}
