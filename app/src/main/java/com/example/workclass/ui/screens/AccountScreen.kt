import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.database.AppDatabase
import com.example.workclass.data.database.DatabaseProvider
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.model.toAccountEntity
import com.example.workclass.data.viewmodel.AccountViewModel
import com.example.workclass.ui.components.AccountCardComponent
import com.example.workclass.ui.components.AccountDetailCardComponent
import com.example.workclass.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
) {
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var accountDetail by remember { mutableStateOf<AccountModel?>(null) }

    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()
    val context = LocalContext.current

    Column {
        TopBarComponent("Accounts", navController, "accounts_screen")

        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if (response.isSuccessful) {
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load data")
                }
            }
        }

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState
        ) {
            items(accounts) { account ->
                AccountCardComponent(
                    account.id,
                    account.name,
                    account.username,
                    account.imageURL.toString(),
                    onButtonClick = {
                        viewModel.getAccount(account.id) { response ->
                            if (response.isSuccessful) {
                                accountDetail = response.body()
                            }
                        }
                        showBottomSheet = true
                    }
                )
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Detalles de la cuenta
                AccountDetailCardComponent(
                    accountDetail?.id ?: 0,
                    accountDetail?.name ?: "",
                    accountDetail?.username ?: "",
                    accountDetail?.password ?: "",
                    accountDetail?.imageURL ?: "",
                    accountDetail?.description ?: "",
                    navController = navController,
                    onSaveClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                accountDetail?.let {
                                    accountDao.insert(it.toAccountEntity())
                                    Log.d("debug-db", "Cuenta insertada correctamente")
                                }
                            } catch (exception: Exception) {
                                Log.d("debug-db", "Error: $exception")
                            }
                        }
                    }
                )
            }
        }
    }
}
