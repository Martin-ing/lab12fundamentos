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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorMixer()
        }
    }
}

@Composable
fun ColorMixer() {
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(170.dp)
                .background(Color(red, blue, green))
        )
        ColorBar(SelectedColor = red, onValueChange = { red = it }, Color = Color.Red)
        ColorBar(SelectedColor = green, onValueChange = { green = it }, Color = Color.Blue)
        ColorBar(SelectedColor = blue, onValueChange = { blue = it }, Color = Color.Green)
    }
}

@Composable
fun ColorBar(SelectedColor: Float, onValueChange: (Float) -> Unit, Color: Color) {

    Slider(
        value = SelectedColor,
        onValueChange = onValueChange,
        valueRange = 0f..1f,
        colors = SliderDefaults.colors(thumbColor = Color)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorMixer()
}