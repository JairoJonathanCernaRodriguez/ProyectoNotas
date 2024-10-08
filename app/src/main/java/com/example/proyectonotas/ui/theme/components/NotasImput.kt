package com.example.proyectonotas.ui.theme.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasImput(
    text: String,
    label: String,
    maxLines: Int,
    onTextChange: (String)->Unit
){
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text( text = label) },
        maxLines = maxLines,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFDFE6EB),
            unfocusedContainerColor = Color(0xFFDFE6EB)
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun NotaButton(
    text: String,
    enabled: Boolean=true,
    onClick:()->Unit
){
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
    ) {
        Text(text=text)
    }
}