# Plan de Assets para Metal Slug Clone

## Visión General

Este documento detalla los assets necesarios para el juego Metal Slug Clone y proporciona una estrategia para obtenerlos. El juego está estructurado para usar LibGDX y requiere archivos específicos en formato PNG.

## Assets Requeridos

### 1. Sprites del Jugador (Player)
- **Archivo:** `player.png`
- **Dimensiones:** 32x48 pixels (o similar)
- **Uso:** Sprite principal del jugador
- **Notas:** Debe incluir múltiples frames para animación (idle, correr, saltar, disparar)

### 2. Sprites de Enemigos
- **Archivo:** `enemy.png`
- **Dimensiones:** 32x32 pixels
- **Uso:** Enemigos básicos del juego
- **Notas:** Debe incluir múltiples frames para animación (idle, caminar, atacar, morir)

### 3. Sprites de Proyectiles
- **Archivo:** `bullet.png`
- **Dimensiones:** 8x8 pixels
- **Uso:** Balas disparadas por el jugador o enemigos
- **Notas:** Sprite simple con alta visibilidad

### 4. Fondos de Nivel
- **Archivos:** `level1.png`, `level2.png`
- **Dimensiones:** 800x600 pixels
- **Uso:** Fondos de los niveles del juego
- **Notas:** Deben ser compatibles con el tamaño de pantalla del juego

### 5. Elementos de UI (Interfaz de Usuario)
- **Barra de vida** (health_bar.png)
- **Indicador de municiones** (ammo.png)
- **Menús** (menu_background.png)
- **Elementos de puntuación** (score.png)

## Recursos Recomendados

### 1. Kenney.nl (https://kenney.nl/assets)
- Recursos gratuitos de alta calidad
- Fuentes tipográficas
- Audio
- Sprite packs

### 2. OpenGameArt.org (https://opengameart.org)
- Recursos gratuitos creados por la comunidad
- Compatible con uso comercial

### 3. Itch.io (https://itch.io/game-assets)
- Sección de assets gratuitos
- Gran variedad de estilos

### 4. LibGDX Assets
- Assets oficiales para LibGDX
- Documentación sobre convenciones

## Estrategia de Descarga

### Paso 1: Descargar Assets Básicos
1. Visitar Kenney.nl y descargar packs de sprites de 2D
2. Buscar assets de Metal Slug estilo específicos
3. Descargar paquetes de sonidos y música

### Paso 2: Organizar los Assets
1. Crear estructura de carpetas según el proyecto
2. Verificar que los archivos tengan dimensiones correctas
3. Convertir formatos si es necesario

### Paso 3: Prueba de Integración
1. Verificar que los assets carguen correctamente
2. Ajustar si es necesario

## Recomendaciones Técnicas

### Para Sprites:
- Usar formato PNG con transparencia
- Dimensiones potenciales de 2^n (16, 32, 64, 128)
- Mantener consistencia en estilo visual
- Tamaños recomendados: 32x32 para enemigos, 32x48 para jugador

### Para Audio:
- Formatos compatibles: MP3, Ogg, WAV
- Archivos de audio de baja latencia
- Música de fondo y efectos de sonido

### Para UI:
- Elementos claros y legibles
- Consistencia visual con estilo del juego
- Tamaños compatibles con resolución del juego

## Próximos Pasos

1. Descargar assets desde repositorios recomendados
2. Verificar compatibilidad con el código del proyecto
3. Organizar assets en estructura correcta
4. Probar carga de assets en el juego