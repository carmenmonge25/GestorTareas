package com.dam.gestortareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam.gestortareas.model.Tarea
import com.dam.gestortareas.ui.theme.GestorTareasTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import com.dam.gestortareas.model.Prioridad
import com.dam.gestortareas.ui.theme.PantallaListado

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestorTareasTheme {
                val tareasPrueba = remember {
                    mutableStateListOf(
                        Tarea(titulo = "Practiva PMM", prioridad = Prioridad.ALTA, completada = true),
                        Tarea(titulo = "Tarea DI", prioridad = Prioridad.MEDIA),
                        Tarea(titulo = "Tarea PI", prioridad = Prioridad.BAJA, completada = false)
                    )
                }
                PantallaListado(
                    tareas = tareasPrueba,
                    onCambiarCompletada = {tareaPulsada ->
                        val pos = tareasPrueba.indexOfFirst { it.id == tareaPulsada.id }
                        if (pos != -1) {
                            tareasPrueba[pos] = tareaPulsada.copy(completada = !tareaPulsada.completada)
                        }
                    },
                    onConfirmarEliminar = {tareaABorrar ->
                        tareasPrueba.remove(tareaABorrar)
                    }
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestorTareasTheme {
        Greeting("Android")
    }
}


