package com.example.practicajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicajetpackcompose.ui.theme.PracticaJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaJetPackComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()){ innerPadding ->
                        InicioWhatsapp(modifier = Modifier.padding(innerPadding))


                    }
                }
            }
        }
    }


@Preview
@Composable
fun InicioWhatsapp(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column (modifier = modifier) {
            WhatsappHeader(modifier = modifier)
            ContactosList(modifier = Modifier)
            Filler(modifier = Modifier)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun WhatsappHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color(0xFF075E54)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(R.string.logo),
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp),
            )

        Spacer(modifier = Modifier.weight(1f))


        Row {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Buscar",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Llamada",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "Más opciones",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun Contacto(modifier: Modifier = Modifier, nombre: String){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "Foto",
            tint = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Text(
            text = nombre,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp),
        )



    }

}

@Preview(showBackground = true)
@Composable
fun ContactoPreview(){
    PracticaJetPackComposeTheme {
        Contacto(modifier = Modifier,"Pedrito")
    }
}

@Preview(showBackground = true)
@Composable
fun ContactosList(modifier: Modifier = Modifier) {
    val contactList = stringArrayResource(R.array.contactos)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(contactList.size) { contacto ->
            Contacto(modifier, contactList[contacto])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Filler(modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    )
}