# Metal Slug Game Assets - Descarga de Recursos

## Descripción
Este documento detalla los recursos necesarios para el proyecto Metal Slug Game, incluyendo los assets requeridos desde diferentes fuentes.

## Fuentes de Assets

### 1. Kenney.nl
**URL:** https://kenney.nl/assets

**Assets Requeridos:**
- **Platformer Characters** - Sprites de jugador con animaciones
- **New Platformer Pack** - Tiles de fondo y elementos de diseño de niveles  
- **UI Pack** - Barras de salud, botones y otros elementos de UI

### 2. OpenGameArt.org
**URL:** https://opengameart.org

**Criterios de Búsqueda:**
- Términos de búsqueda: "platformer" o "pixel art"
- Licencias válidas: CC0 o CC-BY

### 3. Itch.io
**URL:** https://itch.io/game-assets

**Criterios de Búsqueda:**
- Filtros: "free", "platformer" o "pixel art"
- Verificar licencia apropiada para uso comercial

## Estructura de Directorios

```
assets/
├── sprites/
│   ├── player/           # Sprites de jugador
│   ├── enemies/          # Sprites de enemigos  
│   ├── projectiles/             # Sprites de proyectiles
│   └── background/         # Sprites de fondo
├── backgrounds/              # Imágenes de fondo
├── ui/                   # Elementos de interfaz de usuario
└── sounds/                 # Archivos de sonido (si aplica)
```

## Requisitos de Nomenclatura

Los archivos deben ser renombrados para mantener una convención consistente:

- `player_idle.png` en lugar de `player_idle_0.png`
- `player_run1.png` en lugar de `player_walking_0.png`
- `enemy_basic_walk1.png` en lugar de `enemy_walking_0.png`
- `bullet_player.png` en lugar de `projectile.png`

## Procedimiento de Descarga

1. **Preparar directorios:** Los directorios ya están creados en el proyecto
2. **Descargar assets:** Visitar cada fuente y descargar los assets necesarios
3. **Organizar archivos:** Colocar los archivos en las ubicaciones correctas
4. **Renombrar archivos:** Ajustar los nombres de archivo a la convención requerida

## Notas Importantes

- Todos los assets deben tener licencia compatible con el uso comercial
- Los archivos deben estar en formato compatible con motores de juego (PNG, JPG, etc.)
- Verificar la calidad de los assets antes de la organización