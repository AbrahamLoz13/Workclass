package com.example.workclass.ui.screens
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.Switch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclass.R
import com.example.workclass.data_model.MenuModel
import com.example.workclass.data_model.PostCardModel
import com.example.workclass.ui.components.PostCardCompactComponent
import com.example.workclass.ui.components.PostCardComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.Text
@Composable
fun ComponentsScreen(navController: NavHostController){

val menuOption = arrayOf(
    MenuModel(1,"Buttons","Buttons", Icons.Filled.ThumbUp),
    MenuModel(2,"Floating buttons","FloatingButtons", Icons.Filled.Build),
    MenuModel(3,"Progress","Progress", Icons.Filled.Refresh),
    MenuModel(4,"Chips","Chips", Icons.Filled.Person),
    MenuModel(5,"Sliders","Sliders", Icons.Filled.List),
    MenuModel(6,"Switches","Switches", Icons.Filled.Person),
    MenuModel(7,"Badges","Badges", Icons.Filled.ShoppingCart),
    MenuModel(8,"SnackBars","SnackBars", Icons.Filled.Email),
    MenuModel(9,"AlertDialogs","AlertDialogs", Icons.Filled.Warning),
    MenuModel(9,"Bars","Bars", Icons.Filled.Menu),
    MenuModel(10,"InputFields","InputFields", Icons.Filled.AddCircle),
    MenuModel(11,"DatePickers","DatePickers", Icons.Filled.DateRange),
    MenuModel(12,"BottomSheets","BottomSheets", Icons.Filled.Person),
    MenuModel(12,"SegmentedButtons","SegmentedButtons", Icons.Filled.CheckCircle),

)
    var option by rememberSaveable{ mutableStateOf("")}
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menú", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOption) { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = "") },
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                option = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }

                        )
                    }
                }
            }
        }
    ) {
       Column {
           when(option){
               "Buttons"->{
                   Buttons()
               }
               "FloatingButtons"->{
                   FloatingButtons()
               }
               "Progress"->{
                   Progress()
               }
               "Chips"->{
                  Chips()
               }
               "Sliders"->{
                 Sliders()
               }
               "Switches"->{
                Switches()
               }
               "Badges"->{
                   Badges()
               }
               "SnackBars"->{
                   SnackBars()
               }
               "AlertDialogs"->{
                   AlertDialogs()
               }
               "Bars"->{
                   Bars()
               }
               "InputFields"->{
                   Inputfields()
               }
               "DatePickers"->{
                   DatePick()
               }
               "BottomSheets"->{
                   bottomSheets()
               }
               "SegmentedButtons"->{
                   SegmentedButton()
               }


           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun Buttons(){
    // This function displays various types of Material Design buttons.
    // Esta función muestra varios tipos de botones de Material Design.

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}){ // Standard filled button
            Text("Filled") // Botón estándar relleno
        }
        FilledTonalButton(onClick = {}){ // Button with a tonal fill
            Text("Tonal") // Botón con relleno tonal
        }
        OutlinedButton (onClick = {}){ // Button with an outline border
            Text("Outlined") // Botón con borde contorneado
        }
        ElevatedButton(onClick = {}){ // Button with an elevation effect
            Text("Elevated") // Botón con efecto de elevación
        }
        TextButton(onClick = {}){ // Button with just text (no border or fill)
            Text("Text") // Botón solo con texto (sin borde ni relleno)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    // This function displays different types of floating action buttons.
    // Esta función muestra diferentes tipos de botones flotantes de acción.
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(onClick = {}) { // Standard floating action button
            Icon(Icons.Filled.Add,"Add button") // Ícono de añadir en el botón flotante estándar
        }
        SmallFloatingActionButton(onClick = {}) { // Smaller floating action button
            Icon(Icons.Filled.Add,"Add button") // Ícono de añadir en el botón flotante pequeño
        }
        LargeFloatingActionButton(onClick = {}) { // Larger floating action button
            Icon(Icons.Filled.Add,"Add button") // Ícono de añadir en el botón flotante grande
        }
        ExtendedFloatingActionButton(onClick = {}) { // Extended floating action button with icon
            Icon(Icons.Filled.Add,"Add button") // Ícono de añadir en el botón flotante extendido
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Progress() {
    // This function displays progress indicators.
    // Esta función muestra indicadores de progreso.

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth() // Full-width linear progress indicator
        ) // Indicador de progreso lineal de ancho completo
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp) // Circular progress indicator with specified width
        ) // Indicador de progreso circular con ancho especificado
    }
}

@Preview(showBackground = true)
@Composable
fun Chips() {
    // This function displays different types of chip components.
    // Esta función muestra diferentes tipos de chips.

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,
            onClick = {selected = !selected},
            label = { Text("Filter Chip") },
            leadingIcon = if (selected){
                {
                    Icon(Icons.Filled.AccountBox,
                        contentDescription = "Assist chip",
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            }else{
                null
            }
        )
        InputChipExample("Dismiss",{}) // Example of an input chip
    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: ()-> Unit
){
    // This function defines an input chip with a dismiss action.
    // Esta función define un chip de entrada con una acción de eliminación.

    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        label = { Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(Icons.Filled.Person, contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(Icons.Filled.Close, contentDescription = "Close Icon",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Sliders(){
    // This function displays a slider for selecting a value.
    // Esta función muestra un control deslizante para seleccionar un valor.

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Switches(){
    // This function displays switches and checkboxes.
    // Esta función muestra interruptores y casillas de verificación.

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        var checked by remember { mutableStateOf(true)}
        Switch(
            checked = checked,
            onCheckedChange = {checked = it}
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            thumbContent = if(checked2){
                {
                    Icon(Icons.Filled.Check,
                        contentDescription = "Switch check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else null
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun Badges() {
    // This function displays Badges.
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if(itemCount>0){
                    Badge(
                        contentColor = Color.White,
                        containerColor = Color.Red
                    ){
                            Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "shopping car icon"
            )
        }
        Button(onClick = {itemCount++}) {
            Text("Add item")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SnackBars() {
    // This function displays SnackBars.
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
      val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()
SnackbarHost(hostState = snackState)
    fun launchSnackBar(){
snackScope.launch { snackState.showSnackbar("The message has been send") }
     }
        Button(::launchSnackBar) {
            Text("Send message")
        }
    }
    }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ){
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if(showAlertDialog){
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "Icon Warning") },
                title = { Text(text= "Confirm Deletion") },
                text = { Text(text = "Are u sure u want delete this file") },

                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirm"
                            showAlertDialog = false
                        }
                    ) {
                        Text(text = "Yes")
                    }
                },
                dismissButton =  {
                    TextButton(
                        onClick = {
                            selectedOption = "Cancelado"
                            showAlertDialog = false
                        }
                    ) {
                        Text(text = "No")
                    }
                }

            )
        }
        Button(onClick ={showAlertDialog= true}){
            Text(text = "Borrar Archivo")
        }
        Text(selectedOption)
    }
}
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Bars() {
    // Estado de la recarga
    var isRefreshing by remember { mutableStateOf(false) }

    // Estado del PullRefresh
    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            // Simular una carga de datos
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000) // Simula una carga de datos
                isRefreshing = false
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshState)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Barra superior
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    containerColor = Color.Black
                ),
                title = { Text("Screen title") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
                    }
                }
            )

            // Contenido dentro del Pull to Refresh
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Adaptive()
            }

            // Barra inferior
            BottomAppBar(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            ) {
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Warning, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "")
                }
                IconButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Icon(imageVector = Icons.Filled.Create, contentDescription = "")
                }
            }
        }

        // Indicador de recarga
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
fun Adaptive(){
    var windowsSize =currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    //Compact Width < 600 dp Phone Portrait
    //Medium Width >= 600 dp <840 dp Tablet Portrait
    //Expanded Width >= 840 dp Tablet Landscape

    //Compact Height < 480 dp phone landscape
    //Medium Height >= 480 dp <900 dp tablet landscape or phone portrait
    //Expanded Height >= 900 dp tablet portrait

    val arrayPosts = arrayOf(
        PostCardModel(1,"title1","text", R.drawable.amogus),
        PostCardModel(2,"title2","text 2", R.drawable.amogus),
        PostCardModel(3,"title3","text 3", R.drawable.amogus),
        PostCardModel(4,"title4","text 4", R.drawable.amogus),
        PostCardModel(5,"title5","text 5", R.drawable.amogus),
        PostCardModel(6,"title6","text 6", R.drawable.amogus),
        PostCardModel(7,"title7","text 7", R.drawable.amogus),
        PostCardModel(8,"title8","text 8", R.drawable.amogus),
        PostCardModel(9,"title9","text 9", R.drawable.amogus),
    )
    if(width == WindowWidthSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(arrayPosts){ item ->
                PostCardComponent(item.id, item.title, item.text, item.image)
            }
        }
    } else if (height == WindowHeightSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(arrayPosts){ item ->
                PostCardCompactComponent(item.id, item.title, item.text, item.image)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Inputfields(){
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Ingrese texto") },
        modifier = Modifier.fillMaxWidth().padding(16.dp),

    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePick() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    var selectedDate by remember { mutableStateOf("") }

    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _: DatePicker, y: Int, m: Int, d: Int ->
            selectedDate = "$d/${m + 1}/$y"
        },
        year, month, day
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (selectedDate.isNotEmpty()) "Fecha seleccionada: $selectedDate" else "No hay fecha seleccionada",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        Button(onClick = { datePickerDialog.show() }) {
            Text("Seleccionar Fecha")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomSheets(){
    val sheetState = rememberModalBottomSheetState()
    val showSheet = remember { mutableStateOf(false) }

    // Pantalla principal con botón para abrir el Bottom Sheet
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showSheet.value = true }) {
            Text("Abrir Bottom Sheet")
        }
    }

    // Modal Bottom Sheet
    if (showSheet.value) {
        ModalBottomSheet(
            onDismissRequest = { showSheet.value = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Hola buenas tardes", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { showSheet.value = false }) {
                    Text("Cerrar")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SegmentedButton() {
    var selectedSegment by remember { mutableStateOf(0) }
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    val images = listOf(
        painterResource(id = R.drawable.img_1),
        painterResource(id = R.drawable.amogus),
        painterResource(id = R.drawable.gato)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            options.forEachIndexed { index, option ->
                Button(
                    onClick = { selectedSegment = index },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedSegment == index) Color.DarkGray else Color.LightGray
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(option, color = Color.White, fontSize = 16.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = images[selectedSegment],
            contentDescription = "Imagen de ${options[selectedSegment]}",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Seleccionaste: ${options[selectedSegment]}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}