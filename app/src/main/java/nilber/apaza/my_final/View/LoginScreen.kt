package nilber.apaza.my_final.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import nilber.apaza.my_final.R
import androidx.compose.material3.Text as Text1


@Composable
fun Login(auth: FirebaseAuth,navigateBack: () -> Unit,navigateInicio:()->Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Fondo {
        Alinear {
            Titulo(text = "INGRESAR")
            SpacerH(height = 20.dp)
            Imagenes(id = R.drawable.foto)
            SpacerH(height = 30.dp)
            Sombra(
                modifier = Modifier
                    .size(width = 350.dp, height = 300.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color.Gray)
            ){
                Column(modifier = Modifier.padding(20.dp)){
                    Descri(text = "Correo Electronico", color = Color.Black)
                    EspLlenar(value = email, onValueChange = {email=it}, label = "Example@gmail.com")
                    SpacerH(height = 18.dp)
                    Descri(text = "Contraseña", color = Color.Black)
                    EspLlenar(value = password, onValueChange = {password=it}, label = "***********")
                    SpacerH(height = 14.dp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CheckBox(text = "Recordar?")
                    }
                }
            }
            SpacerH(height = 20.dp)
            Row {
                Boton(text = "Atras",
                    onClick = {navigateBack()},
                    width = 158.dp,
                    height = 52.dp)

                SpaceW(width = 20.dp)

                Boton(text = "Iniciar",
                    onClick = { auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task->
                        if(task.isSuccessful){
                            //navegar
                            navigateInicio()
                        }else{
                            //error
                        }
                    } },
                    width = 158.dp,
                    height = 52.dp)
            }
        }
    }
}
