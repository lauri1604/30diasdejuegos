# MEMORY.md — Courses
Memoria del proyecto entre sesiones. Máximo ~50 líneas: resume o elimina lo que ya no
aporte.
## Estado actual
- La app compila con la paleta azul celeste Material 3 en `ui/theme/Color.kt` (color fuente `#29B6F6`).
- `Theme.kt` conserva un único tema `_30DiasDeJuegosTheme`; el color dinámico está desactivado por defecto para poder evaluar la paleta elegida.
- Al reemplazar una paleta, conservar el paquete `com.example.a30diasdejuegos.ui.theme` y no pegar su contenido dentro de `Theme.kt`.
- `model/Game.kt` representa día, IDs de nombre/descripción y recurso de imagen; `data/Dataresource.kt` entrega 30 juegos ordenados para los 30 días. Nombres y descripciones iniciales propuestos según los recursos gráficos disponibles.
- `MainActivity` muestra la lista con `GameList` y `LazyColumn`; cada tarjeta se construye desde su `Game`, con recursos de texto e imagen. `GameListPreview` carga el catálogo completo desde `Dataresource`; la vista previa muestra el área visible y permite desplazarse.
- `Type.kt` aplica Patrick Hand a títulos y textos de la pantalla. Su licencia SIL OFL está en `licenses/OFL-Patrick-Hand.txt`; las fuentes anteriores se retiraron.
- Validación actual: `./gradlew assembleDebug --no-daemon` correcto.