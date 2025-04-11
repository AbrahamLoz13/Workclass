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
import androidx.compose.ui.graphics.painter.Painter
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

@Composable
fun FavoriteAccountScreen(navController: NavController){

    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }
    LaunchedEffect(
        Unit
    ) {
        accountsdb = withContext(Dispatchers.IO) {
            accountDao.getAll()
        }
    }

    Column () {
        TopBarComponent("Favorite Accounts",
            navController,
            "favorite_accounts_screen")
        val listState = rememberLazyListState()
        LazyColumn(modifier = Modifier
            .fillMaxSize(),
            state = listState){
            items(accountsdb) { accountdb ->
                FavoriteAccountCard(
                    accountdb.id ?: 0,
                    accountdb.name ?: "",
                    accountdb.username ?: "",
                    accountdb.password ?: "",
                    accountdb.description ?: "",
                    accountdb.imageURL ?: "",
                    onDeleteClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            try{
                                accountDao.delete(accountdb)
                                accountsdb = withContext(Dispatchers.IO){
                                    accountDao.getAll()
                                }

                            }catch (exception: Exception){
                                Log.d("debug-db", "Error: $exception")
                            }
                        }
                    }
                )
            }
        }
    }
}
