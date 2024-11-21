package com.example.practicajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.navegacion.Navigation.AppNavigation
import com.example.practicajetpackcompose.ui.theme.PracticaJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaJetPackComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()){ innerPadding ->
                        AppNavigation(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }


