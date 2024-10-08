package com.example.proyectonotas.ui.theme.main.views


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.Surface
import com.example.proyectonotas.ui.theme.components.NotaButton
import com.example.proyectonotas.ui.theme.components.NotasImput
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val isDarkTheme = isSystemInDarkTheme() // Detectar si el sistema está en modo oscuro
    // Definir colores manualmente usando formato hexadecimal
    val backgroundColor = if (isDarkTheme) Color(0xFF121212) else Color(0xFFFFFFFF) // Modo oscuro: fondo gris oscuro
    val textColor = if (isDarkTheme) Color(0xFFFFFFFF) else Color(0xFF000000) // Modo oscuro: texto blanco
    val buttonColor = if (isDarkTheme) Color(0xFFBBBBBB) else Color(0xFF0000FF)
    //Titulo de la Nota
    var titulo by remember {
        mutableStateOf("")
    }
    //Descripcion de la nota
    var descripcion by remember{
        mutableStateOf("")
    }
    Column {
        TopAppBar(title = { Text(text = "Mis Notas")}
        )}
    Column(
        modifier = Modifier
            .fillMaxSize() // Llena toda la pantalla
            .padding(16.dp), // Ajusta el padding si es necesario
        verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        NotasImput(
            text = titulo,
            label = "Escribe el titulo",
            maxLines = 2,
            onTextChange = {
                titulo = it
            },
            textColor = textColor // Cambiar color del texto
        )
        NotasImput(
            text = descripcion,
            label = "Escribe tu nota",
            maxLines = 5,
            onTextChange = {
                descripcion = it
            },
            textColor = textColor // Cambiar color del texto
        )
        Spacer(modifier = Modifier.height(16.dp))
        NotaButton(text = "Guardar Nota", buttonColor = buttonColor) {
            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                titulo = ""
                descripcion = ""
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasImput(
    text: String,
    label: String,
    maxLines: Int,
    onTextChange: (String) -> Unit,
    textColor: Color // Recibir el color del texto
) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = label, color = textColor) }, // Cambiar color del label
        maxLines = maxLines,
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor, // Cambiar color del texto cuando está enfocado
            unfocusedTextColor = textColor, // Cambiar color del texto cuando no está enfocado
            focusedContainerColor = Color.Transparent, // Fondo transparente cuando está enfocado
            unfocusedContainerColor = Color.Transparent // Fondo transparente cuando no está enfocado
        )
    )
}

@Composable
fun NotaButton(text: String, buttonColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor // Cambiar color del botón
        )
    ) {
        Text(text = text)
    }
}
