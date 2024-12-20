
package nilber.apaza.my_final.Model.models

data class Vehiculo(
    val descripcion: String,
    val marca: String,
    val modelo: String,
    val anio: Int,
    val kilometraje: Int,
    val color: String,
    val numeroPlaca: String,
    val numeroMotor: String,
    val combustible: String,
    val cilindrada: Int,
    val potencia: Int,
    val valvulas: Int,
    val motor: String,
    val traccion: String,
    val transmision: String,
    val largo: Double,
    val ancho: Double,
    val altura: Double,
    val peso: Double,
    val capacidadCarga: Double,
    val numeroTelefono: String,
    val foto: String?,
    val terminosCondiciones: Boolean,
    val precio: Double
)