package com.example.practicajetpackcompose.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.Navigation.AppScreen

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    val mockNavControler = rememberNavController()
    ChatScreen(modifier = Modifier, mockNavControler, "Pedrito", "Mensaje|Prueba")
}

@Composable
fun ChatScreen(modifier: Modifier = Modifier, navController: NavController, nombre: String?, mensajes: String?) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(modifier = modifier) {
            ChatHeader(modifier = Modifier, nombre, navController)
            ChatBody(modifier = Modifier, mensajes)
            MessageTextBox(modifier = Modifier)
        }
    }
}

@Composable
fun ChatBody(modifier: Modifier = Modifier, mensajes: String?) {


    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.Start

    ) {
        val mensajesList = mensajes?.split("|")
        if (mensajesList != null) {
            mensajesList.forEach {
            Mensaje(modifier = Modifier, it)
        }
        }



    }


}

@Composable
fun Mensaje(
    modifier: Modifier = Modifier,
    texto: String
) {
    Row(
        modifier = modifier
            .padding(5.dp)
            .background(
                color = Color(0xFFD4EDC6),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = texto,
            modifier = Modifier.padding(8.dp) // Espaciado interno
        )
    }
}


@Composable
fun ChatHeader(modifier: Modifier = Modifier, nombre: String?, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color(0xFF075E54)),
        verticalAlignment = Alignment.CenterVertically
    )
    {


        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Volver",
            tint = Color.White,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable(
                    true,
                    onClick = { navController.navigate(route = AppScreen.FirstScreen.route) })
        )

        Text(
            text = nombre!!,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp),
        )


    }
}

@Preview(showBackground = true)
@Composable
fun MessageTextBox(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = { Text("Mensaje") }
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF075E54)
                ),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Enviar",
                    tint = Color.White
                )
            }
        }
    }

}