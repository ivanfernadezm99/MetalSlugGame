# Arquitectura Técnica del Juego Metal Slug Clone

## Visión General

Esta documentación describe la arquitectura técnica del juego Metal Slug Clone, un juego estilo run-and-gun inspirado en la saga clásica Metal Slug. El juego está desarrollado utilizando el motor LibGDX para proporcionar portabilidad entre plataformas PC y dispositivos Android.

## Estructura del Sistema

### Componentes Principales

1. **Game** - Clase principal de la aplicación
2. **GameScreen** - Pantalla principal del juego
3. **Player** - Entidad del jugador principal
4. **Enemy** - Entidades enemigas
5. **Weapon** - Sistemas de armas y proyectiles
6. **Level** - Nivel del juego y gestión de objetos
7. **InputManager** - Gestión de entrada del usuario
8. **ResourceManager** - Gestión de recursos gráficos y de audio
9. **CollisionManager** - Sistema de detección de colisiones

## Diagrama de Componentes

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Game App     │    │  GameScreen    │    │   Player      │
│                 │    │                │    │                 │
│  - Main Entry     │◄───┤  - Game Loop   │◄───┤  - Movement     │
│  - State Mgmt   │    │  - Render      │    │  - Shooting    │
│  - Screens       │    │  - Update      │    │  - Health     │
└─────────────────┘    │  - Input Mgr│    │  - Animation     │
                     │                │  - Physics       │
                     └────────────────┘  └───────────────┘
                             │
                             ▼
                     ┌─────────────────┐
                     │   Level Manager     │
                     │                   │
                     │  - Enemies        │
                     │  - Weapons       │
                     │  - Background      │
                     │  - Collision Mgr    │
                     └─────────────────┬───┘
                                    │
                                    ▼
                     ┌─────────────────┐
                     │   Collision     │
                     │   Manager         │
                     └─────────────────┬─┘
                                    │
                                    ▼
                     ┌─────────────────┐
                     │   Input Mgr     │
                     │                 │
                     │  - Keyboard     │
                     │  - Touch       │
                     │  - Gamepad      │
                     └───────────────┘
```

## Sistema de Componentes

### Clase Game
La clase principal de la aplicación que gestiona el ciclo de vida del juego y las pantallas.

```java
public class Game extends ApplicationAdapter {
    private Screen currentScreen;
    
    @Override
    public void create() {
        currentScreen = new GameScreen(this);
        setScreen(currentScreen);
    }
    
    @Override
    public void render() {
        super.render();
    }
}
```

### Clase GameScreen
Gestiona el estado actual del juego, renderización y actualización del juego.

```java
public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Player player;
    private Level level;
    
    @Override
    public void render(float delta) {
        // Actualización y renderizado del juego
    }
}
```

### Clase Player
Representa al jugador principal con movimientos, salud y sistema de armas.

```java
public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private int health;
    private int lives;
    private boolean isJumping;
    
    public void update(float deltaTime) {
        // Lógica de movimiento y actualización
    }
    
    public void shoot() {
        // Lógica de disparo
    }
    
    public void jump() {
        // Lógica de salto
    }
}
```

### Clase Enemy
Representa los enemigos del juego con comportamiento básico.

```java
public class Enemy {
    private Vector2 position;
    private Vector2 velocity;
    private int health;
    private EnemyType type;
    
    public void update(float deltaTime) {
        // Lógica de IA básica
    }
}
```

### Clase Weapon
Representa los proyectiles disparados por el jugador o enemigos.

```java
public class Weapon {
    private Vector2 position;
    private Vector2 velocity;
    private int damage;
    private WeaponType type;
    private boolean isActive;
    
    public void update(float deltaTime) {
        // Actualización de posición
    }
}
```

### Clase Level
Gestiona todos los elementos del nivel, incluyendo enemigos, objetos y colisiones.

```java
public class Level {
    private Texture background;
    private List<Enemy> enemies;
    private List<Weapon> weapons;
    private List<GameObject> objects;
    
    public void update(float deltaTime) {
        // Actualiza todos los objetos del nivel
    }
    
    public void render(SpriteBatch batch) {
        // Renderiza todos los elementos del nivel
    }
}
```

## Gestión de Recursos

### ResourceManager
Sistema centralizado para carga y gestión de recursos.

```java
public class ResourceManager {
    private Map<String, Texture> textures;
    private Map<String, Sound> sounds;
    private Map<String, Music> music;
    
    public Texture loadTexture(String path) {
        // Carga de texturas
    }
    
    public Sound loadSound(String path) {
        // Carga de sonidos
    }
}
```

### Sistema de Texturas
- Carga eficiente de texturas desde archivos PNG
- Gestión de memoria para recursos gráficos
- Reutilización de texturas

### Sistema de Audio
- Carga de archivos de audio (MP3, WAV)
- Reproducción de efectos de sonido
- Gestión de volumen

## Sistema de Entrada

### InputManager
Gestiona las entradas del usuario para diferentes plataformas.

```java
public class InputManager {
    private InputProcessor inputProcessor;
    private boolean[] keys;
    
    public void handleInput() {
        // Procesa entradas de teclado
        // Procesa entradas táctiles
    }
}
```

### Control para PC
- Teclado para movimiento (flechas)
- Barra espaciadora para disparo
- Tecla de salto (espacio o flecha arriba)

### Control para Móvil
- Deslizamiento para movimiento
- Toque en pantalla para disparo
- Gestos para acciones especiales

## Sistema de Renderizado

### Renderizado de Escena
El sistema de renderizado gestiona la presentación visual del juego con las siguientes capas:

1. **Fondo** - Capa de fondo del nivel
2. **Objetos del nivel** - Enemigos, obstáculos
3. **Jugador** - Entidad principal
4. **Proyectiles** - Balas y explosiones
5. **UI** - Interfaz de usuario

### Sistema de Cámara
```java
public class Camera {
    private OrthographicCamera camera;
    private float x, y;
    private float width, height;
    
    public void follow(GameObject target) {
        // Seguimiento de objeto objetivo
    }
}
```

## Sistema de Colisiones

### CollisionManager
Gestiona la detección y manejo de colisiones entre objetos.

```java
public class CollisionManager {
    public void checkCollisions() {
        // Colisión jugador-enemigo
        // Colisión bala-enemigo
        // Colisión bala-obstáculo
    }
}
```

## Sistema de Física

### Sistema de Gravedad
Implementación básica de gravedad para movimiento del jugador.

```java
public class Physics {
    public void applyGravity(Player player, float deltaTime) {
        player.getVelocity().y -= GRAVITY * deltaTime;
    }
}
```

### Sistema de Movimiento
- Movimiento horizontal (correr, saltar)
- Sistema de salto único por suelo
- Fricción y aceleración

## Gestión de Estados

### Estados del Juego
- **Menu Principal**
- **Jugando**
- **Pausa**
- **Game Over**
- **Nivel Completado**

### Transiciones de Estado
```java
public enum GameState {
    MENU,
    PLAYING,
    PAUSED,
    GAME_OVER,
    LEVEL_COMPLETE
}
```

## Portabilidad entre Plataformas

### Soporte para PC
- Utiliza LibGDX backend lwjgl3 para renderizado OpenGL
- Controles de teclado estándar
- Soporte para emuladores

### Soporte para Android
- Utiliza LibGDX backend para Android
- Controles táctiles optimizados
- Gestos y orientación de pantalla

## Optimización de Rendimiento

### Reutilización de Objetos
- Pool de objetos para balas y partículas
- Reciclaje de recursos inactivos
- Reducción de llamadas de renderizado

### Gestión de Memoria
- Carga eficiente de recursos
- Limpieza de recursos no utilizados
- Manejo de memoria para dispositivos móviles

## Consideraciones de Seguridad

### Validación de Entrada
- Validación de datos de usuario
- Protección contra entradas inválidas
- Manejo de errores

### Seguridad de Recursos
- Verificación de archivos de recursos
- Protección contra acceso no autorizado

## Configuración de Compilación

### Gradle
- Gestión de dependencias
- Configuración de compilación multiplataforma
- Automatización de procesos

## Pruebas y Validación

### Pruebas Unitarias
- Tests para componentes individuales
- Validación de lógica de juego
- Pruebas de rendimiento

### Pruebas de Integración
- Tests para interacción entre componentes
- Validación del flujo completo del juego
- Pruebas de portabilidad

## Documentación de API

### Clases Principales
- Game - Punto de entrada de la aplicación
- GameScreen - Pantalla principal del juego
- Player - Entidad del jugador
- Enemy - Entidad enemiga
- Weapon - Sistema de armas
- Level - Nivel del juego
- InputManager - Gestor de entrada
- ResourceManager - Gestor de recursos

## Dependencias Principales

### LibGDX
- gdx: Motor de juego multiplataforma
- gdx-backend-lwjgl3: Backend para PC
- gdx-platform: Recursos para PC
- gdx-box2d: Sistema de física
- ashley: Framework ECS
- gdx-ai: Biblioteca de inteligencia artificial

## Configuración del Entorno
### Requisitos de Desarrollo

- JDK 21
- Gradle 6.0 o superior
- IntelliJ IDEA o Eclipse
- LibGDX 1.12.0

### Configuración de Compilación
- Archivo build.gradle
- Configuración de recursos
- Dependencias del proyecto

## Consideraciones Futuras

### Mejoras de Rendimiento
- Sistema de streaming de recursos
- Optimización de shaders
- Sistema de particulas avanzado

### Funcionalidades Adicionales
- Sistema de guardado
- Modo multijugador
- Niveles adicionales
- Sistema de mejoras