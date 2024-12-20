package nilber.apaza.my_final.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.auth.FirebaseAuth
import nilber.apaza.my_final.View.AutoMarket
import nilber.apaza.my_final.View.DetalleVehiculoScreen
import nilber.apaza.my_final.View.ListaVehiculosScreen
//import nilber.apaza.my_final.View.Formulario
import nilber.apaza.my_final.View.Login
import nilber.apaza.my_final.View.LoginReg
import nilber.apaza.my_final.View.LoginScreen
/*
sealed class Routes(val route: String) {
    object CarList : Routes("car_list")
    object CarDetail : Routes("car_detail")
}
@Composable
fun NavegationWrap(auth: FirebaseAuth) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Index",) {
        composable("Index") {
            LoginScreen(
                navigateToLogin = { navController.navigate("Login") },
                navigateToRegister = { navController.navigate("Registro") }
            )
        }
        composable("Login") {
            Login(auth = auth,
                navigateInicio = { navController.navigate("IndexG") },
                navigateBack = { navController.navigateUp() },
            )
        }
        composable("Registro") {
            LoginReg(auth = auth,
                navigateReg = { navController.navigate("IndexG") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable("IndexG") {
            AutoMarket(
                navigateCom = { navController.navigate("Catalogo") },
                navigateVen = { navController.navigate("Formulario") }
            )
        }
        composable("Formulario") {
            Formulario()
        }
        composable("Catalogo") {
            Formulario()
        }
    }
}
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.CarList.route) {
        composable(Routes.CarList.route) {
            CarListScreen(navController)
        }
        composable(Routes.CarDetail.route) {
            CarDetailScreen()
        }
    }
}*/
@Composable
fun MainNavGraph(viewModel: VehiculoViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaVehiculosScreen(viewModel) { vehiculoId ->
                navController.navigate("detalle/$vehiculoId")
            }
        }
        composable(
            route = "detalle/{vehiculoId}",
            arguments = listOf(navArgument("vehiculoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val vehiculoId = backStackEntry.arguments?.getInt("vehiculoId") ?: 0
            DetalleVehiculoScreen(viewModel, vehiculoId) {
                navController.popBackStack()
            }
        }
    }
}
