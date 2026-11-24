package com.dam.gestortareas.ui.theme

import com.dam.gestortareas.model.Tarea
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.AlertDialog


@Composable
fun PantallaListado(
    tareas: List<Tarea>,
    onCambiarCompletada: (Tarea) -> Unit,
    onConfirmarEliminar: (Tarea) -> Unit) {
    var tareaParaEliminar by remember { mutableStateOf<Tarea?>(null) }
    if (tareas.isEmpty()) {
        Text(text = "No hay tareas todavía.")
    } else {
        LazyColumn {
            items(tareas) { tarea ->
                Row(modifier = Modifier.padding(8.dp)){
                    Checkbox(
                        checked = tarea.completada,
                        onCheckedChange = {onCambiarCompletada(tarea)}
                    )
                    Text(text = tarea.titulo)
                    Text(text = "Prioridad: ${tarea.prioridad}")
                    Text(text = if (tarea.completada) "Completada" else "Pendiente")
                    TextButton(onClick = {tareaParaEliminar = tarea}) {
                        Text(text = "Eliminar")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        if (tareaParaEliminar != null) {
            val actual = tareaParaEliminar!!
            AlertDialog(
                onDismissRequest = { tareaParaEliminar = null },
                title = { Text("Confirmar") },
                text = { Text("¿Eliminar ${actual.titulo}?") },
                confirmButton = {
                    TextButton(onClick = {
                        onConfirmarEliminar(actual)
                        tareaParaEliminar = null
                    }) { Text("Eliminar") }
                },
                dismissButton = {
                    TextButton(onClick = { tareaParaEliminar = null }) { Text("Cancelar") }
                }
            )
        }
    }

}
