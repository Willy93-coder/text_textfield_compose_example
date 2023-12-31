package com.example.textandtextfieldincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.textandtextfieldincompose.ui.theme.TextAndTextfieldInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextAndTextfieldInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var myText by remember {
                        mutableStateOf("")
                    }
                    Column(Modifier.fillMaxSize()) {
                        MyOutlinedTextField(myText) { myText = it }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField(name: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(value = name, onValueChange = { onValueChanged(name) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text(text = "Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") })
}


@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Esto es un ejemplo",
        )
        Text(
            text = "Esto es un ejemplo",
            color = Color.Blue
        )
        Text(
            text = "Esto es un ejemplo",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Esto es un ejemplo",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough, TextDecoration.Underline
                )
            )
        )
        Text(
            text = "Esto es un ejemplo",
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextAndTextfieldInComposeTheme {
        MyTextFieldAdvance()
    }
}