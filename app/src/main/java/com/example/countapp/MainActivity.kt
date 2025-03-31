package com.example.countapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//Esta parte del codigo ejecuta la aplicacion
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorMixer()
        }
    }
}

//Aplicacion principal
@Composable
fun ColorMixer() {
    //Estas variables guardan los valores de RGB
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Color Mixer", style = MaterialTheme.typography.headlineMedium)

        //Caja donde se despliega el color resultante
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(170.dp)
                .background(Color(red, green, blue))
        )

        //Se mandan a llamar a las barras para el color
        ColorBar(SelectedColor = red, onValueChange = { red = it }, Color = Color.Red, colorStr = "Red")
        ColorBar(SelectedColor = green, onValueChange = { green = it }, Color = Color.Green, colorStr = "Green")
        ColorBar(SelectedColor = blue, onValueChange = { blue = it }, Color = Color.Blue, colorStr = "Blue")
    }
}

//Funcion para cada barra de color
@Composable
fun ColorBar(SelectedColor: Float, onValueChange: (Float) -> Unit, Color: Color, colorStr: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        //Se muestra el nombre del color y su valor de 0 a 255
        Text("${colorStr}: ")
        Text("${(SelectedColor * 255).toInt()}")
    }

    //Barra donde se selecciona la magnitud
    Slider(
        value = SelectedColor,
        onValueChange = onValueChange,
        valueRange = 0f..1f,
        colors = SliderDefaults.colors(thumbColor = Color)
    )
}

//Esta parte del codigo ejecuta solo el preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorMixer()
}