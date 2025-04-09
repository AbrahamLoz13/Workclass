package com.example.workclass
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclass.data.database.AppDataBase
import com.example.workclass.data.database.DatabaseProvider
import com.example.workclass.ui.screens.AccountsScreen
import com.example.workclass.ui.screens.ComponentsScreen
import com.example.workclass.ui.screens.HomeScreen
import com.example.workclass.ui.screens.LoginScreen
import com.example.workclass.ui.screens.MainMenuScreen
import com.example.workclass.ui.screens.ManageAccountScreen
import com.example.workclass.ui.screens.TestScreen
import com.example.workclass.ui.theme.Pink80
import com.example.workclass.ui.theme.WorkclassTheme
class MainActivity : ComponentActivity() {
    lateinit var dataBase: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            dataBase = DatabaseProvider.getDatabase(this)
            Log.d("debug-db","Database loaded successfully")
        }catch (exception:Exception){
            Log.d("debug-db","ERROR: $exception")
        }
        setContent {
            WorkclassTheme {
                ComposeMultiScreenApp()
            }
        }
    }
    @Composable
    fun ComposeMultiScreenApp() {
        val navController = rememberNavController()
        SetUpNavGraph(navController = navController)
    }
    @Composable
    fun SetUpNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = "MainMenu_Screen"
        ) {
            composable("MainMenu_Screen") { MainMenuScreen(navController) }
            composable("Home_Screen") { HomeScreen(navController) }
            composable("Test_Screen") { TestScreen(navController) }
            composable("Instagram_Screen") { com.example.workclass.ui.screens.InstagramHome(navController) }
            composable("Components_Screen") { ComponentsScreen(navController) }
            composable("Login_screen") { LoginScreen(navController) }
            composable("accounts_screen") { AccountsScreen(navController) }
            composable("manage_account_screen") { ManageAccountScreen(navController) }

        }
    }
}