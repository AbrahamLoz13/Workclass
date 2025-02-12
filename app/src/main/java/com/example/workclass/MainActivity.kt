package com.example.workclass
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workclass.ui.theme.Pink80
import com.example.workclass.ui.theme.WorkclassTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad
        setContent {
            WorkclassTheme {
                // Se organiza la UI en Columnas y Filas
                Column {
                    Column {
                        // Se llaman a composables para mostrar texto
                        TextComposable("Roberto")
                        TextComposable("Pepe")
                        TextComposable("Lopez")
                        TextComposable("Juanito")
                    }
                    Row {
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Column {
                        ModifierExample2()
                        ModifierExample4()
                        CustomText()
                    }
                }
            }
        }
    }
    // Composable que muestra un texto, con un nombre por defecto
    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name: String = "Empty") {
        Text("Welcome")
        Text(name)
    }
    // Preview es para mostrar la función sin correr la app
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample1() {
        // Función que aplica un padding a un texto
        Column(modifier = Modifier.padding(35.dp, 24.dp, 10.dp, 15.dp)) {
            Text("Hello word")
        }
    }
    @Preview
    @Composable
    fun ModifierExample2() {
        // Función que añade padding, ocupa el ancho máximo, permite clics y cambia el fondo
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(onClick = { clickAction() })

        ) {
            Text(text = "Hello word")
        }
    }
    // Función que se ejecuta al hacer clic
    fun clickAction() {
        println(":) onClick")
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample3() {
        // Función que crea una columna con altura completa, padding, fondo, borde y alineaciones
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxHeight()
                .padding(25.dp)
                .border(width = 2.dp, color = Color.Black)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComposable("1")
            TextComposable("2")
            TextComposable("3")

            TextComposable("4")
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample4() {
       //dos maneras de acceder a los modifiers
        //1,. con una variable, 2.-  con modifier.propiedad
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .padding(10.dp)
                .width(300.dp)
                .height(300.dp)
        ){
            Text("1",Modifier.align(Alignment.TopStart))
            Text("2",Modifier.align(Alignment.TopCenter))
            Text("3",Modifier.align(Alignment.TopEnd))
            Text("4",Modifier.align(Alignment.CenterStart))
            Text("5",Modifier.align(Alignment.Center))
            Text("6",Modifier.align(Alignment.CenterEnd))
            Text("7",Modifier.align(Alignment.BottomStart))
            Text("8",Modifier.align(Alignment.BottomCenter))
            Text("9",Modifier.align(Alignment.BottomEnd))
        }
}
    @Preview(showBackground = true)
    @Composable
    fun CustomText(){
        Column() {
            Text(
                stringResource(R.string.app_name),
                color = colorResource(R.color.purple_500),
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold
            )
            val gradientColors = listOf(Color.Gray,Color.Magenta, colorResource(R.color.purple_200))
            Text(
                stringResource(R.string.app_name),
                style= TextStyle(brush = Brush.linearGradient(colors = gradientColors ))
            )
        }
    }

}