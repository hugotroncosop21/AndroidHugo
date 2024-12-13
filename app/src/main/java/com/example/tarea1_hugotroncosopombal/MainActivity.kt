package com.example.tarea1_hugotroncosopombal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarea1_hugotroncosopombal.ui.theme.Tarea1_HugoTroncosoPombalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Inicio(name = "hugo")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {
    //SCAFFOLD
    Scaffold(
        //TOPBAR(appBar)
        topBar = {
            TopAppBar(
                title = { Text(text = "Programa de concienciación con el cambio climático",
                color = Color(0xFF006400))}
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                // IMAGEN
                Image(
                    painter = painterResource(id = R.drawable.imagen1), // Aquí se asegura de usar la referencia correcta a la imagen
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                // TEXTO QUYE DESCRIBE UNA FUNCIONALIDAD
                Text(
                    text = "Aplicación sin ánimo de lucro, con el objetivo de concienciar y mostrar los cambios que sufre nuestro planeta",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.DarkGray // Color texto explicativo
                )
                //LISTA DE ELEMENTOS, SIMULA DISTINTAS PESTAÑAS EN LAS QUE ACCEDER A DIFERENTE INFORMACIÓN
                val datos = listOf("1. Energía y emisiones", "2. Impactos sobre la naturaleza", "3. Adaptación y mitigación", "4. Políticas y sostenibilidad")
                LazyColumn (
                    modifier = Modifier.padding(16.dp) // Bordes en la lista
                ){
                    items(datos) { item ->
                        Text(
                            text = item,
                            modifier = Modifier.padding(vertical = 8.dp),
                            color = Color.Blue // Color en la lista
                        )
                    }
                }
            }
        }
    )
}
