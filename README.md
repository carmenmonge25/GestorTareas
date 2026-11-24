# Gestor de Tareas (Android / Kotlin / Jetpack Compose)

Aplicación Android desarrollada en **Kotlin** con **Jetpack Compose** como proyecto de práctica para el ciclo formativo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**. Permite gestionar tareas de forma visual mediante un prototipo interactivo con listado desplazable, cambio de estado de completado y confirmación de borrado mediante diálogo.

---

## Funcionalidades implementadas

* **Modelo de datos de tarea:**
  * Enumerado `Prioridad` para definir los niveles (`BAJA`, `MEDIA`, `ALTA`).
  * Clase de datos `Tarea` con propiedades para identificador (`id`), título (`titulo`), descripción (`descripcion`), prioridad (`prioridad`) y estado (`completada`), incluyendo valores por defecto.
* **Pantalla de listado (`PantallaListado`):**
  * Muestra un mensaje informativo cuando no existen tareas (`"No hay tareas todavía."`).
  * Renderiza las tareas en un `LazyColumn` mostrando casilla de selección (`Checkbox`), título, prioridad, estado (`Completada` / `Pendiente`) y botón de eliminación.
  * Solicita confirmación mediante un `AlertDialog` antes de eliminar una tarea, permitiendo cancelar o confirmar la acción.
* **Prototipo interactivo en memoria (`MainActivity`):**
  * Lista observable con `remember` y `mutableStateListOf` para probar en tiempo real el cambio de estado (`copy`) y la eliminación de elementos.

---

## Organización básica del proyecto

Basado en la estructura del paquete `com.dam.gestortareas`:

```text
GestorTareas-master/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/dam/gestortareas/
│           │   ├── MainActivity.kt
│           │   ├── model/
│           │   │   ├── Prioridad.kt
│           │   │   └── Tarea.kt
│           │   └── ui/
│           │       └── theme/
│           │           ├── Color.kt
│           │           ├── PantallaListado.kt
│           │           ├── Theme.kt
│           │           └── Type.kt
│           └── res/
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
└── settings.gradle.kts
```

*(Nota: `PantallaListado.kt` se encuentra actualmente ubicada dentro de `ui/theme/`).*

---

## Bibliotecas utilizadas

* **Kotlin** (con Gradle Kotlin DSL en `build.gradle.kts` y `settings.gradle.kts`).
* **Jetpack Compose** y **Material 3** (`LazyColumn`, `Checkbox`, `AlertDialog`, `TextButton`, `Row`, `Spacer`, gestión de estado con `remember`, `mutableStateOf` y `mutableStateListOf`).
* **AndroidX Core / Activity Compose** (configuradas a través de Android Studio y el catálogo de versiones `gradle/libs.versions.toml`).

---

## Instrucciones para ejecutar la aplicación

1. Clona o descarga el repositorio (`GestorTareas-master`) en tu equipo.
2. Abre **Android Studio** y selecciona **File > Open** (o **Open** en la pantalla de bienvenida) eligiendo la carpeta raíz del proyecto.
3. Espera a que **Gradle Sync** finalice y descargue las dependencias necesarias.
4. Selecciona un emulador Android configurado (o conecta un dispositivo con depuración USB habilitada) en la barra superior de ejecución.
5. Pulsa **Run** (botón verde de reproducción o `Shift + F10`) para compilar e instalar la aplicación.

---

## Configuraciones de los dos emuladores utilizados

Completa los datos exactos de los dos AVD (Android Virtual Devices) que hayas empleado en Android Studio Device Manager:

| Parámetro | Emulador 1 | Emulador 2 |
| :--- | :--- | :--- |
| **Nombre del AVD / Dispositivo** | `[Ej: Medium Phone API 35]` | `[Ej: Small Phone / Tablet API 34]` |
| **Versión de Android / API Level** | `[Ej: Android 15 (API 35)]` | `[Ej: Android 14 (API 34)]` |
| **Arquitectura (ABI)** | `[Ej: x86_64 / arm64-v8a]` | `[Ej: x86_64 / arm64-v8a]` |
| **Resolución y densidad** | `[Ej: 1080 x 2400, 420 dpi]` | `[Ej: Ej: 1080 x 1920, 320 dpi]` |
| **RAM / Almacenamiento** | `[Ej: 2 GB RAM]` | `[Ej: 2 GB RAM]` |

---

## Tabla de pruebas realizadas y resultados obtenidos

| ID | Caso de prueba | Pasos realizados | Resultado esperado | Resultado obtenido | Estado |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **CP-01** | Lista vacía | Iniciar con lista de tareas vacía | Mostrar el mensaje `"No hay tareas todavía."` | `[Completa el resultado real]` | `[OK / Pendiente]` |
| **CP-02** | Visualización de tareas | Cargar tareas de ejemplo en `MainActivity` | Mostrar título, prioridad, estado y controles en `LazyColumn` | `[Completa el resultado real]` | `[OK / Pendiente]` |
| **CP-03** | Marcar / desmarcar completada | Pulsar el `Checkbox` de una tarea | Alternar entre `Pendiente` y `Completada` y actualizar casilla | `[Completa el resultado real]` | `[OK / Pendiente]` |
| **CP-04** | Cancelar eliminación | Pulsar **Eliminar** y luego **Cancelar** en el diálogo | Cerrar el diálogo y mantener la tarea en la lista | `[Completa el resultado real]` | `[OK / Pendiente]` |
| **CP-05** | Confirmar eliminación | Pulsar **Eliminar** y confirmar en el diálogo | Quitar la tarea de la lista visible | `[Completa el resultado real]` | `[OK / Pendiente]` |

---

## Enlace al chat de IA usado durante el desarrollo

* Enlace a la conversación de asistencia: [`chat de IA`](https://gemini.google.com/app/4ad4cb31fedd89b7?hl=es-ES&pli=1)

---

## Incidencias conocidas o funcionalidades que no se hayan podido completar

* **Persistencia con base de datos Room:** los datos se gestionan actualmente en memoria (`mutableStateListOf`) y se pierden al cerrar o reiniciar la aplicación; la integración con Room queda pendiente.
* **Creación y edición de tareas:** aún no se ha implementado el formulario para añadir nuevas tareas (con validación de título y selector de prioridad) ni la edición de tareas existentes.
* **Ubicación de `PantallaListado.kt`:** el archivo está alojado dentro de `ui/theme/` en lugar de directamente en `ui/`.
* **Otras incidencias observadas:** `[Añade aquí cualquier incidencia adicional detectada durante tus pruebas]`.
