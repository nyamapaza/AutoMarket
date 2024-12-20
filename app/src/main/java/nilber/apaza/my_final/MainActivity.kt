package nilber.apaza.my_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import nilber.apaza.my_final.View.Formulario.FormularioVehiculo
import nilber.apaza.my_final.View.ListaVehiculosScreen
import nilber.apaza.my_final.ViewModel.MainNavGraph
//import nilber.apaza.my_final.View.Formulario
import nilber.apaza.my_final.ViewModel.VehiculoViewModel
import nilber.apaza.my_final.ui.theme.My_FinalTheme

class MainActivity : ComponentActivity() {

  //  private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  auth = Firebase.auth
        enableEdgeToEdge()
        setContent {
            My_FinalTheme {
                //NavegationWrap(auth)
                //val navController = rememberNavController()
               // Navigation(navController)
                //FormularioVehiculo(VehiculoViewModel())
                MainNavGraph(VehiculoViewModel())
            }
        }
    }

   /* override fun onStart() {
        super.onStart()
        val currentUser=auth.currentUser
        if(currentUser!=null){
            //navegar a inicio
            auth.signOut()
        }
    }*/
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_FinalTheme {
        Greeting("Android")
    }
}