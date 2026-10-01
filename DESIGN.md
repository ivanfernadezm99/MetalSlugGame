# Diseño Técnico para MetalSlug Game

## Visión General

Este documento describe el diseño técnico detallado para completar el desarrollo del juego MetalSlug Game Clone. El diseño se enfoca en la arquitectura modular, la separación de responsabilidades y la integración efectiva de los componentes principales.

## Arquitectura General

### Patrón de Arquitectura
El sistema seguirá el patrón de arquitectura orientada a componentes con una estructura de capas clara:

```
┌─────────────────────────────────────────────────────────────────┐
│                        Capa de Presentación                 │
├─────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐   │
│  │   UIManager   │  │   AudioManager    │  │   InputManager    │   │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘   │
└─────────────────┬─────────────────┬─────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                        Capa de Lógica de Negocio                        │
├─────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐   │
│  │   LevelManager    │  │  ScoreManager     │  │  SaveManager        │   │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘   │
└─────────────────────────────────────────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                        Capa de Recursos                         │
├─────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐   │
│  │   ResourceManager   │  │ CollisionManager│  │   GameScreen    │   │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘   │
└─────────────────────────────────────────────────────────────────────────┘
```

## Componentes Detallados

### 1. AudioManager (Gestor de Audio)

#### Responsabilidades
- Carga de archivos de audio
- Reproducción de música de fondo
- Reproducción de efectos de sonido
- Control de volumen
- Gestión de recursos de audio

#### Diseño de Implementación
```java
public class AudioManager {
    private Map<String, Music> musicMap;
    private Map<String, Sound> soundMap;
    private float musicVolume;
    private float soundVolume;
    
    public void loadMusic(String name, String path) { ... }
    public void playMusic(String name) { ... }
    public void stopMusic() { ... }
    public void loadSound(String name, String path) { ... }
    public void playSound(String name) { ... }
    public void setMusicVolume(float volume) { ... }
    public void setSoundVolume(float volume) { ... }
}
```

### 2. UIManager (Gestor de Interfaz de Usuario)

#### Responsabilidades
- Gestión de pantallas (menú, juego, pausa, game over)
- Renderizado de elementos de UI
- Actualización de indicadores (vida, municiones)
- Gestión de eventos de UI

#### Diseño de Implementación
```java
public class UIManager {
    private Screen currentScreen;
    private Map<ScreenType, Screen> screens;
    private HUD hud;
    
    public void showScreen(ScreenType type) { ... }
    public void updateHUD(int health, int ammo) { ... }
    public void renderUI() { ... }
}
```

### 3. LevelManager (Gestor de Niveles)

#### Responsabilidades
- Gestión de niveles
- Creación de niveles
- Sistema de objetivos
- Transiciones entre niveles

#### Diseño de Implementación
```java
public class LevelManager {
    private List<Level> levels;
    private Level currentLevel;
    private int currentLevelIndex;
    
    public void loadLevel(int levelNumber) { ... }
    public void createNewLevel() { ... }
    public void checkLevelObjectives() { ... }
    public void transitionToNextLevel() { ... }
}
```

### 4. ScoreManager (Gestor de Puntuación)

#### Responsabilidades
- Cálculo de puntuación
- Sistema de bonificaciones
- Gestión de puntuaciones altas

#### Diseño de Implementación
```java
public class ScoreManager {
    private int currentScore;
    private int highScore;
    private List<Bonus> bonuses;
    
    public void addScore(int points) { ... }
    public void addBonus(int bonusPoints) { ... }
    public void saveHighScore() { ... }
    public int getScore() { ... }
    public int getHighScore() { ... }
}
```

### 5. SaveManager (Gestor de Guardado)

#### Responsabilidades
- Guardado de partidas
- Carga de partidas
- Gestión de estados de juego

#### Diseño de Implementación
```java
public class SaveManager {
    private String saveFilePath;
    
    public void saveGame() { ... }
    public void loadGame() { ... }
    public void saveGameState() { ... }
    public void loadGameState() { ... }
}
```

### 6. ResourceManager (Gestor de Recursos)

#### Responsabilidades
- Carga de recursos gráficos y de audio
- Gestión de memoria de recursos
- Sistema de pool de objetos

#### Diseño de Implementación
```java
public class ResourceManager {
    private Map<String, Texture> textureMap;
    private Map<String, Music> musicMap;
    private Map<String, Sound> soundMap;
    
    public Texture loadTexture(String path) { ... }
    public Music loadMusic(String path) { ... }
    public Sound loadSound(String path) { ... }
}
```

## Flujo de Juego

### Diagrama de Flujo Principal

```
[Inicio del Juego]
        │
        ▼
[Menú Principal]
        │
        ├─[Jugar]─▶ [Nivel 1]
        │              │
        │              ▼
        │        [GameScreen]
        │              │
        │              ▼
        │        [Colisiones]
        │              │
        │              ▼
        │        [Puntuación]
        │              │
        │              ▼
        │        [Guardado]
        │              │
        │              ▼
        │        [Transición]
        │              │
        │              ▼
        └─[Salir]───────[Fin]
```

## Sistema de Estados del Juego

### Enumeración de Estados

```java
public enum GameState {
    MENU,
    PLAYING,
    PAUSED,
    GAME_OVER,
    LEVEL_COMPLETE,
    VICTORY
}
```

### Transiciones de Estado

```java
public class GameStateManager {
    private GameState currentState;
    
    public void changeState(GameState newState) {
        this.currentState = newState;
        // Lógica de transición
    }
}
```

## Sistema de Colisiones

### ColisionManager

```java
public class CollisionManager {
    public void checkCollisions() {
        // Colisión jugador-enemigo
        // Colisión bala-enemigo
        // Colisión bala-obstáculo
        // Colisión jugador-obstáculo
    }
}
```

## Sistema de Entrada

### InputManager

```java
public class InputManager {
    private InputProcessor processor;
    private boolean[] keys;
    
    public void handleInput() {
        // Procesamiento de entradas
        // Teclado para PC
        // Toque para móvil
    }
}
```

## Diseño de Niveles

### Estructura de Nivel

```java
public class Level {
    private String name;
    private int levelNumber;
    private List<GameObject> objects;
    private List<Enemy> enemies;
    private List<Weapon> weapons;
    private Background background;
    private List<Objective> objectives;
    
    public void update(float deltaTime) { ... }
    public void render(SpriteBatch batch) { ... }
}
```

### Objetivos de Nivel

```java
public abstract class Objective {
    protected boolean completed;
    protected String description;
    
    public abstract boolean checkComplete();
    public abstract void update(float deltaTime);
}
```

## Sistema de HUD (Heads-Up Display)

### HUD

```java
public class HUD {
    private int health;
    private int ammo;
    private int score;
    private BitmapFont font;
    
    public void render(SpriteBatch batch) { ... }
    public void updateHUD(int health, int ammo, int score) { ... }
}
```

## Sistema de Puntuación

### ScoreSystem

```java
public class ScoreSystem {
    private int baseScore;
    private int bonusScore;
    private int totalScore;
    private Map<String, Integer> bonuses;
    
    public void calculateScore(Enemy enemy) { ... }
    public void addBonus(String bonusType) { ... }
    public void saveHighScore() { ... }
}
```

## Sistema de Guardado

### GameSave

```java
public class GameSave {
    private int level;
    private int score;
    private int health;
    private int ammo;
    private List<String> collectedItems;
    private List<Enemy> enemyStatus;
    
    public void saveToFile(String fileName) { ... }
    public void loadFromFile(String fileName) { ... }
}
```

## Optimización de Rendimiento

### Sistema de Pool de Objetos

```java
public class ObjectPool<T> {
    private Queue<T> available;
    private Supplier<T> factory;
    
    public T acquire() {
        return available.isEmpty() ? factory.get() : available.poll();
    }
    
    public void release(T object) {
        available.offer(object);
    }
}
```

## Consideraciones de Portabilidad

### Soporte Multiplataforma

```java
public class PlatformManager {
    private boolean isMobile;
    private boolean isDesktop;
    
    public void setupInput() {
        if (isMobile) {
            // Configuración para móvil
        } else {
            // Configuración para PC
        }
    }
}
```

## Gestión de Recursos

### Sistema de Recursos Cargados

```java
public class ResourceManager {
    private static ResourceManager instance;
    private Map<String, Asset> assets;
    
    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }
    
    public void preloadAssets() { ... }
    public void unloadAssets() { ... }
}
```

## Diagrama de Clases

### Diagrama Principal

```
┌─────────────────────────────────────────────────────────────────────┐
│                    AudioManager                           │
├─────────────────────────────────────────────────────────────┤
│ - musicMap: Map<String, Music>                              │
│ - soundMap: Map<String, Sound>                       │
│ - musicVolume: float                                        │
│ - soundVolume: float                                        │
│                                                             │
│ + loadMusic(name: String, path: String)                    │
│ + playMusic(name: String)                                       │
│ + stopMusic()                                               │
│ + loadSound(name: String, path: String)                │
│ + playSound(name: String)                                │
│ + setMusicVolume(volume: float)                           │
│ + setSoundVolume(volume: float)                                 │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────┐
│                    UIManager                              │
├─────────────────────────────────────────────────────────────┤
│ - currentScreen: Screen                                   │
│ - screens: Map<ScreenType, Screen>                     │
│ - hud: HUD                                                   │
│                                                             │
│ + showScreen(type: ScreenType)                      │
│ + updateHUD(health: int, ammo: int)                         │
│ + renderUI()                                                   │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    LevelManager                                   │
├─────────────────────────────────────────────────────────────────────┤
│ - levels: List<Level>                                       │
│ - currentLevel: Level                                     │
│ - currentLevelIndex: int                                    │
│                                                             │
│ + loadLevel(levelNumber: int)                               │
│ + createNewLevel()                                         │
│ + checkLevelObjectives()                                      │
│ + transitionToNextLevel()                                    │
└─────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────┐
│                    ScoreManager                               │
├─────────────────────────────────────────────────────────────┤
│ - currentScore: int                                       │
│ - highScore: int                                          │
│ - bonuses: List<Bonus>                                       │
│                                                             │
│ + addScore(points: int)                                    │
│ + addBonus(bonusPoints: int)                          │
│ + saveHighScore()                                           │
│ + getScore(): int                                         │
│ + getHighScore(): int                                      │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                    SaveManager                            │
├─────────────────────────────────────────────────────────────────────┤
│ - saveFilePath: String                                       │
│                                                             │
│ + saveGame()                                                │
│ + loadGame()                                                │
│ + saveGameState()                                   │
│ + loadGameState()                                              │
└─────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│                    GameScreen                              │
├─────────────────────────────────────────────────────────────────────┤
│ - game: Game                                               │
│ - camera: OrthographicCamera                            │
│ - batch: SpriteBatch                                      │
│ - player: Player                                             │
│ - levelManager: LevelManager                             │
│ - audioManager: AudioManager                        │
│ - uiManager: UIManager                                    │
│                                                             │
│ + render(deltaTime: float)                                   │
│ + update(deltaTime: float)                                      │
│ + handleInput()                                              │
└─────────────────────────────────────────────────────────────────────────────┘
```

## Consideraciones de Seguridad

### Validación de Entrada
- Validación de datos de usuario
- Protección contra entradas inválidas
- Manejo de errores

### Seguridad de Recursos
- Verificación de archivos de recursos
- Protección contra acceso no autorizado

## Pruebas y Validación

### Pruebas Unitarias
- Test para cada componente
- Test para lógica de juego
- Test para sistema de puntuación

### Pruebas de Integración
- Test de flujo completo del juego
- Test de interacción entre componentes
- Test de sistema de guardado

## Documentación de API

### Clases Principales
- AudioManager - Gestor de sonido
- UIManager - Gestor de interfaz de usuario
- LevelManager - Gestor de niveles
- ScoreManager - Gestor de puntuación
- SaveManager - Gestor de guardado
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
- JDK 8 o superior
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
- Sistema de partículas avanzado

### Funcionalidades Adicionales
- Sistema de guardado
- Modo multijugador
- Niveles adicionales
- Sistema de mejoras