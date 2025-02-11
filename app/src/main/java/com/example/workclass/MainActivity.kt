package com.example.workclass
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workclass.ui.theme.WorkclassTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            WorkclassTheme {
                //Row:fila
                //Column:Columna
                Column(){
                    Column (){
                        TextComposable("Roberto")
                        TextComposable("Pepe")
                        TextComposable("Lopez")
                        TextComposable("Juanito")
                    }
                    Row() {
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                }
              }
            }
        }
    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name:String = "Empty"){
        Text("Welcome")
        Text(name)
    }
    //Preview es para mostrar la funcion sin correr el codigo
    @Preview(showBackground = true)
    @Composable
    //Funcion que tiene un padding
    fun ModifierExample1(){
        Column (modifier = Modifier .padding(35.dp,24.dp,10.dp,15.dp)){
            Text("Hello word")

        }
    }

    @Preview(showBackground = true)
    @Composable
    //Funcion que tiene un fill maz size que llena la pantalla
    fun ModifierExample2() {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth()


        ) {
Text("Hello")
        }


    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample3(){
        Column(
modifier = Modifier
    .fillMaxHeight()
    .padding(25.dp)
    .background(Color.Cyan)
    .border(width= 2.dp, color = Color.Black)
    .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            TextComposable("1")
            TextComposable("2")
            TextComposable("3")
            TextComposable("4")
        }
    }
}


