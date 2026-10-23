# MEMORY.md — Courses
Memoria del proyecto entre sesiones. Máximo ~50 líneas: resume o elimina lo que ya no
aporte.
## Estado actual
- La app compila con la paleta azul celeste Material 3 en `ui/theme/Color.kt` (color fuente `#29B6F6`).
- `Theme.kt` conserva un único tema `_30DiasDeJuegosTheme`; el color dinámico está desactivado por defecto para poder evaluar la paleta elegida.
- Al reemplazar una paleta, conservar el paquete `com.example.a30diasdejuegos.ui.theme` y no pegar su contenido dentro de `Theme.kt`.
- Validación actual: `./gradlew assembleDebug --no-daemon` correcto.