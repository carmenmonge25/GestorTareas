package com.dam.gestortareas.model

data class Tarea(
    val id: Int = 0,
    val titulo: String,
    val descripcion: String = "",
    val prioridad: Prioridad = Prioridad.MEDIA,
    val completada: Boolean = false
)
