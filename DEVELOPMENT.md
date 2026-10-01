# Guía de Desarrollo para Metal Slug Clone

## Visión General

Esta guía proporciona toda la información necesaria para el desarrollo continuo del juego Metal Slug Clone, desde la configuración inicial hasta las mejores prácticas de desarrollo.

## Estructura del Proyecto

```
MetalSlugGame/
├── src/                    # Código fuente
│   ├── Game.java           # Clase principal del juego
│   ├── Main.java           # Punto de entrada
│   ├── GameScreen.java       # Pantalla principal del juego
│   ├── Player.java          # Clase del jugador
│   ├── Enemy.java      # Clase de enemigos
│   ├── Weapon.java          # Clase de armas/proyectiles
│   ├── Level.java         # Clase del nivel
│   ├── InputManager.java      # Gestor de entrada
│   ├── CollisionManager.java # Gestor de colisiones
│   └── ResourceManager.java # Gestor de recursos
├── assets/                   # Recursos del juego
│   ├── sprites/              # Sprites del juego
│   ├── backgrounds/          # Fondos de nivel
│   ├── sounds/           # Efectos de sonido
│   └── fonts/              # Fuentes tipográficas
├── docs/                 # Documentación técnica
│   ├── DESIGN.md          # Diseño del juego
│   ├── IMPLEMENTATION.md # Implementación
│   ├── ARCHITECTURE.md      # Arquitectura técnica
│   └── DEVELOPMENT.md       # Guía de desarrollo
├── build/                  # Archivos de compilación
│   └── libs/               # Librerías compiladas
├── gradle/              # Configuración de Gradle
├── tests/                     # Pruebas unitarias
│   └── GameTest.java       # Pruebas del juego
├── build.gradle             # Archivo de construcción
├── settings.gradle             # Configuración de proyecto
├── gradlew                 # Script de Gradle (Linux/macOS)
├── gradlew.bat               # Script de Gradle (Windows)
└── README.md              # Documentación principal
```

## Configuración del Entorno de Desarrollo

### Requisitos

1. **JDK 21**
2. **Gradle 6.0+**
3. **IDE (IntelliJ IDEA o Eclipse)**
4. **Git**
5. **LibGDX 1.12.0**

### Paso a Paso de Configuración

#### 1. Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/metal-slug-clone.git
cd metal-slug-clone
```

#### 2. Configurar el IDE
- Abrir el proyecto en IntelliJ IDEA o Eclipse
- Importar el proyecto como proyecto Gradle
- Configurar las dependencias automáticamente

#### 3. Verificar las Dependencias
```bash
./gradlew dependencies
```

#### 4. Compilar el Proyecto
```bash
./gradlew build
```

### Configuración de Variables de Entorno

#### Variables del Sistema
```bash
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk
export PATH=$JAVA_HOME/bin:$PATH
export GRADLE_HOME=/usr/local/gradle
export PATH=$GRADLE_HOME/bin:$PATH
```

#### Variables del Proyecto
```properties
# En gradle.properties
org.gradle.jvmargs=-Xmx1024m
game.version=1.0.0
game.name=Metal Slug Clone
```

## Estructura de Código

### Clase Principal (Game.java)
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

### Pantalla Principal (GameScreen.java)
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

### Clase del Jugador (Player.java)
```java
public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private int health;
    
    public void update(float deltaTime) {
        // Lógica de movimiento y actualización
    }
    
    public void render(SpriteBatch batch) {
        // Renderizado del jugador
    }
}
```

## Mejores Prácticas de Desarrollo

### 1. Organización de Código

#### Nomenclatura
- Nombres de clases: PascalCase (Ej: GameScreen, Player)
- Nombres de métodos: camelCase (Ej: updatePlayer, renderEnemy)
- Nombres de variables: camelCase (Ej: playerPosition, enemyHealth)
- Nombres de constantes: UPPER_SNAKE_CASE (Ej: MAX_SPEED, GRAVITY)

#### Estructura de Carpetas
```
src/
├── com.metal.slug.game/
│   ├── core/           # Lógica principal
│   ├── entities/       # Entidades del juego
│   ├── screens/       # Pantallas
│   ├── systems/         # Sistemas del juego
│   └── utils/          # Utilidades
```

### 2. Manejo de Recursos

#### Gestión de Texturas
```java
public class ResourceManager {
    private Map<String, Texture> textures;
    
    public Texture loadTexture(String path) {
        if (textures.containsKey(path)) {
            return textures.get(path);
        }
        
        Texture texture = new Texture(path);
        textures.put(path, texture);
        return texture;
    }
}
```

#### Gestión de Sonido
```java
public class AudioManager {
    private Map<String, Sound> sounds;
    
    public void playSound(String soundName) {
        if (sounds.containsKey(soundName)) {
            sounds.get(soundName).play();
        }
    }
}
```

### 3. Manejo de Entrada

#### Sistema de Entrada
```java
public class InputManager {
    public void handleInput() {
        // Procesamiento de entradas para PC
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // Mover jugador a la izquierda
        }
        
        // Procesamiento de entradas para móvil
        if (Gdx.input.isTouched()) {
            // Manejo táctil
        }
    }
}
```

### 4. Sistemas de Colisiones

#### Sistema de Colisiones
```java
public class CollisionManager {
    public boolean checkCollision(GameObject obj1, GameObject obj2) {
        // Cálculo de colisión entre objetos
        return obj1.getBounds().overlaps(obj2.getBounds());
    }
}
```

## Herramientas de Desarrollo

### IDE Configurado

#### IntelliJ IDEA
- Plugin de LibGDX
- Plugin de Gradle
- Configuración de ejecución automática

#### Eclipse
- Plugin de Gradle
- Configuración de LibGDX
- Scripts de ejecución

### Herramientas de Compilación

#### Gradle
```bash
# Compilar todo el proyecto
./gradlew build

# Ejecutar pruebas
./gradlew test

# Limpiar compilación
./gradlew clean

# Ejecutar el juego
./gradlew run
```

### Herramientas de Debugging

#### Debugging en PC
```bash
# Ejecutar con debug
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar build/libs/metal-slug-game-desktop-1.0.0.jar
```

#### Debugging en Android
```bash
# Usar Android Studio para debugging
# O usar adb con debugging remoto
```

## Sistemas de Control de Versiones

### Git Workflow

#### Estructura de Ramas
```
main              # Rama principal estable
develop           # Rama de desarrollo
feature/*         # Ramas de características
bugfix/*            # Ramas de correcciones
release/*       # Ramas de lanzamiento
hotfix/*        # Ramas de correcciones urgentes
```

#### Procedimiento de Commits
```bash
# Convenciones de commit
feat: Agregar nueva funcionalidad
fix: Corregir error
docs: Actualizar documentación
style: Cambios de estilo
refactor: Refactorización
test: Añadir pruebas
chore: Cambios de mantenimiento
```

#### Ejemplo de Commit
```bash
git commit -m "feat: Add player movement system"
git commit -m "fix: Correct enemy collision detection"
git commit -m "docs: Update README with installation guide"
```

### Procedimiento de Merge

1. Crear una rama feature desde develop
2. Implementar funcionalidades
3. Realizar pruebas
4. Crear Pull Request
5. Revisión por pares
6. Merge a develop
7. Test final en develop
8. Merge a main (si es release)

## Procedimientos de Pruebas

### Pruebas Unitarias

#### Estructura de Pruebas
```java
public class PlayerTest {
    @Test
    public void testPlayerMovement() {
        // Prueba de movimiento del jugador
    }
    
    @Test
    public void testPlayerHealth() {
        // Prueba del sistema de salud
    }
}
```

### Pruebas de Integración

#### Ejemplo de prueba de integración
```java
public class GameIntegrationTest {
    @Test
    public void testGameLoop() {
        // Prueba del ciclo de juego
    }
}
```

## Documentación del Código

### Comentarios de Código

#### Estilo de Comentarios
```java
/**
 * Sistema de movimiento del jugador
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class PlayerMovement {
    // Código del sistema
}
```

#### Comentarios de Métodos
```java
/**
 * Actualiza la posición del jugador
 * 
 * @param deltaTime tiempo desde el último frame
 * @param player jugador a actualizar
 */
public void updatePlayerPosition(float deltaTime, Player player) {
    // Implementación
}
```

### Generación de Documentación

#### Javadoc
```bash
# Generar documentación con Javadoc
./gradlew javadoc
```

## Optimización de Rendimiento

### Sistema de Pool de Objetos

#### Ejemplo de Pool
```java
public class ObjectPool<T> {
    private Queue<T> pool;
    
    public T acquire() {
        return pool.isEmpty() ? createNew() : pool.poll();
    }
    
    public void release(T object) {
        pool.offer(object);
    }
}
```

### Gestión de Memoria

#### Limpieza de Recursos
```java
public class ResourceManager {
    public void dispose() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();
    }
}
```

## Mejoras de Desarrollo

### Sistema de Configuración

#### Archivo de Configuración
```properties
# game.properties
game.title=Metal Slug Clone
game.version=1.0.0
game.debug.enabled=false
game.fps.limit=60
```

### Sistema de Logs

#### Logger de Desarrollo
```java
public class GameLogger {
    public static void log(String message) {
        if (DEBUG_ENABLED) {
            System.out.println("[DEBUG] " + message);
        }
    }
}
```

## Compatibilidad Multiplataforma

### Configuración de Plataformas

#### Configuración para PC
```java
// Para backend de PC
backend = new Lwjgl3ApplicationConfiguration();
```

#### Configuración para Android
```java
// Para backend de Android
backend = new AndroidApplicationConfiguration();
```

### Sistema de Adaptación

#### Adaptación de Control
```java
public class InputAdapter {
    public void processInput(boolean isMobile) {
        if (isMobile) {
            // Lógica de entrada móvil
        } else {
            // Lógica de entrada PC
        }
    }
}
```

## Entrega Continua

### Proceso de Entrega

1. **Compilación Automática**
   ```bash
   ./gradlew build
   ```

2. **Pruebas Automáticas**
   ```bash
   ./gradlew test
   ```

3. **Generación de Artefactos**
   ```bash
   ./gradlew dist
   ```

4. **Despliegue Automático**
   ```bash
   ./gradlew deploy
   ```

## Herramientas de Monitoreo

### Sistema de Métricas
```java
public class GameMetrics {
    private int framesRendered = 0;
    private long lastFrameTime = 0;
    
    public void recordFrame() {
        framesRendered++;
        if (System.currentTimeMillis() - lastFrameTime >= 1000) {
            System.out.println("FPS: " + framesRendered);
            framesRendered = 0;
            lastFrameTime = System.currentTimeMillis();
        }
    }
}
```

## Recomendaciones de Desarrollo

### Para Desarrolladores Principales

1. **Mantener la consistencia de código**
2. **Escribir pruebas unitarias**
3. **Documentar funciones complejas**
4. **Realizar revisiones de código**
5. **Seguir las convenciones de nombres**

### Para Desarrolladores Novatos

1. **Comprender la estructura básica del juego**
2. **Leer la documentación existente**
3. **Solicitar ayuda cuando sea necesario**
4. **Realizar pruebas de sus cambios**
5. **Participar en revisiones de código**

## Actualizaciones y Mejoras

### Proceso de Actualización

1. **Identificación de mejoras**
2. **Evaluación de impacto**
3. **Diseño de solución**
4. **Implementación**
5. **Pruebas**
6. **Documentación**
7. **Lanzamiento**

### Sistemas de Actualización
```java
public class UpdateSystem {
    public void checkForUpdates() {
        // Lógica para verificar actualizaciones
    }
    
    public void applyUpdate(String updatePath) {
        // Lógica para aplicar actualización
    }
}
```

## Soporte y Mantenimiento

### Sistema de Soporte
```java
public class SupportSystem {
    public void logError(Exception error) {
        // Registro de errores
    }
    
    public void sendSupportRequest(String issue) {
        // Enviar solicitud de soporte
    }
}
```

## Cierre

Esta guía de desarrollo está diseñada para proporcionar todas las herramientas y directrices necesarias para el desarrollo continuo del juego Metal Slug Clone. Sigue estas prácticas para mantener un código limpio, eficiente y fácil de mantener.