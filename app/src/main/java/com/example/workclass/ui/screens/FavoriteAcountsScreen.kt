import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.workclass.data.database.AppDatabase
import com.example.workclass.data.database.DatabaseProvider
import com.example.workclass.data.model.AccountEntity
import com.example.workclass.ui.components.FavoriteAccountCard
import com.example.workclass.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Composable principal para la pantalla de cuentas favoritas
@Composable
fun FavoriteAccountScreen(navController: NavController) {

    // Obtener la base de datos y DAO para las operaciones de base de datos
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()

    // Estado para almacenar las cuentas favoritas obtenidas de la base de datos
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }

    // Obtener las cuentas de la base de datos en un hilo de IO
    LaunchedEffect(Unit) {
        accountsdb = withContext(Dispatchers.IO) {
            accountDao.getAll()  // Obtener todas las cuentas favoritas
        }
    }

    // Componer la pantalla
    Column {
        // Barra superior con el título y acciones
        TopBarComponent("Favorite Accounts", navController, "favorite_accounts_screen")

        // Estado para la lista perezosa (LazyColumn)
        val listState = rememberLazyListState()

        // Mostrar las cuentas favoritas en una lista
        LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
            // Iterar sobre las cuentas y mostrarlas
            items(accountsdb) { accountdb ->
                // Componente de tarjeta para cada cuenta favorita
                FavoriteAccountCard(
                    accountdb.id ?: 0,  // ID de la cuenta
                    accountdb.name ?: "",  // Nombre de la cuenta
                    accountdb.username ?: "",  // Nombre de usuario de la cuenta
                    accountdb.password ?: "",  // Contraseña de la cuenta
                    accountdb.description ?: "",  // Descripción de la cuenta
                    accountdb.imageURL ?: "",  // URL de la imagen de la cuenta
                    onDeleteClick = {
                        // Eliminar la cuenta de la base de datos en un hilo de IO
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                accountDao.delete(accountdb)  // Eliminar la cuenta de la base de datos
                                // Volver a cargar las cuentas después de la eliminación
                                accountsdb = withContext(Dispatchers.IO) {
                                    accountDao.getAll()  // Obtener nuevamente todas las cuentas
                                }
                            } catch (exception: Exception) {
                                // Manejar errores al eliminar la cuenta
                                Log.d("debug-db", "Error: $exception")
                            }
                        }
                    }
                )
            }
        }
    }
}
