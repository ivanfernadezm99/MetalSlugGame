# Assets del Juego Metal Slug

Esta carpeta contiene todos los recursos gráficos, de audio y otros elementos necesarios para el juego.

## Estructura de Carpetas

- `sprites/` - Sprites de personajes, enemigos y objetos
- `backgrounds/` - Imágenes de fondo de los niveles
- `ui/` - Elementos de interfaz de usuario
- `sounds/` - Sonidos y música
- `fonts/` - Fuentes tipográficas

## Recursos Necesarios

### Sprites
- Jugador principal (32x48 pixels)
- Enemigos (32x32 pixels)
- Balas/Proyectiles (8x8 pixels)
- Objetos coleccionables (16x16 pixels)

### Fondos
- Nivel 1 (800x600 pixels)
- Nivel 2 (800x600 pixels)

### Audio
- Música de fondo (MP3/Ogg)
- Efectos de sonido (WAV/MP3)

### UI
- Barra de vida
- Indicador de municiones
- Menú principal

## Notas de Implementación

Los recursos deben seguir las siguientes convenciones:
- Todos los sprites deben ser en formato PNG
- Las texturas deben tener dimensiones potenciales de 2^n (16, 32, 64, 128, etc.)
- Los archivos de audio deben estar en formato compatible con LibGDX

## Recomendaciones para Assets Únicos

Para asegurar la publicación del juego, es importante usar assets únicos que no copien directamente de juegos existentes como Metal Slug. Se recomienda:

1. Utilizar recursos gratuitos con licencias compatibles (CC0, CC-BY)
2. Crear sprites únicos con diferentes estilos o colores
3. Evitar copiar directamente los diseños de personajes o niveles
4. Utilizar fuentes como Kenney.nl o OpenGameArt.org que ofrecen assets libres para uso comercial

## Estructura de Directorios Específica

Según el código del juego, se espera la siguiente estructura:
- `assets/sprites/player/` - Sprites del jugador
- `assets/sprites/enemies/` - Sprites de enemigos
- `assets/sprites/projectiles/` - Sprites de proyectiles
- `assets/backgrounds/` - Fondos de nivel