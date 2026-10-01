# Implementación del Juego Metal Slug Clone

## Visión General

Este documento detalla la implementación técnica del juego estilo Metal Slug 1. Se basa en el motor LibGDX para proporcionar portabilidad entre plataformas.

## Tecnologías Utilizadas

### LibGDX
- Motor de juego multiplataforma
- Soporte para PC y dispositivos móviles
- Gestión de recursos y renderizado
- Sistema de entrada y sonido

### Lwjgl3
- Backend de LibGDX para PC
- Soporte para OpenGL
- Gestión de ventanas y renderizado

### Gradle
- Sistema de construcción y gestión de dependencias
- Automatización del proceso de compilación

## Estructura del Proyecto

```
MetalSlugGame/
├── src/
│   ├── Game.java              # Clase principal de la aplicación
│   ├── Main.java         # Punto de entrada
│   ├── GameScreen.java    # Pantalla principal del juego
│   ├── Player.java         # Clase del jugador
│   ├── Enemy.java              # Clase de enemigos
│   ├── Weapon.java             # Clase de armas/proyectiles
│   └── Level.java      # Clase del nivel
├── assets/
│   ├── sprites/               # Sprites del juego
│   ├── backgrounds/           # Fondos de nivel
│   ├── sounds/                # Archivos de audio
│   └── ui/                  # Elementos de interfaz
├── docs/
│   ├── DESIGN.md            # Diseño del juego
│   └── IMPLEMENTATION.md    # Implementación
├── build/
│   └── libs/                # Librerías compiladas
├── build.gradle             # Archivo de construcción
├── settings.gradle          # Configuración de proyecto
└── README.md                # Documentación principal
```

## Implementación de Componentes

### Sistema de Jugador (Player.java)
El jugador es la entidad principal del juego con las siguientes características:

#### Características
- Movimiento horizontal (correr, saltar)
- Sistema de vida y salud
- Control de dirección (izquierda/derecha)
- Sistema de invencibilidad temporal

#### Métodos Principales
- `update(float deltaTime)`: Actualiza posición y estado
- `render(SpriteBatch batch)`: Renderiza el jugador
- `moveLeft()`, `moveRight()`: Control de movimiento horizontal
- `jump()`: Salto del jugador
- `takeDamage(int damage)`: Recibir daño y actualizar salud

### Sistema de Enemigos (Enemy.java)
Los enemigos son entidades que el jugador debe eliminar.

#### Características
- Movimiento básico
- Sistema de vida y salud
- Estado de vida (activo/muerto)
- Detección de colisiones

#### Métodos Principales
- `update(float deltaTime)`: Actualiza posición y estado
- `render(SpriteBatch batch)`: Renderiza al enemigo
- `takeDamage(int damage)`: Recibir daño
- `isAlive()`: Verificar estado de vida

### Sistema de Armas (Weapon.java)
Los proyectiles son creados por el jugador y los enemigos.

#### Características
- Movimiento lineal
- Sistema de vida activa/inactiva
- Cálculo de daño
- Detección de colisión

#### Métodos Principales
- `update(float deltaTime)`: Actualiza posición y estado
- `render(SpriteBatch batch)`: Renderiza el proyectil
- `isActive()`: Verificar estado de vida
- `getDamage()`: Obtener cantidad de daño

### Sistema de Nivel (Level.java)
Gestiona todos los elementos del nivel.

#### Características
- Renderizado de fondo
- Gestión de enemigos
- Gestión de proyectiles
- Sistema de actualización

#### Métodos Principales
- `update(float deltaTime)`: Actualiza todos los elementos del nivel
- `render(SpriteBatch batch)`: Renderiza el nivel completo
- `addEnemy(Enemy enemy)`: Agregar enemigo al nivel
- `addWeapon(Weapon weapon)`: Agregar arma al nivel

### Pantalla Principal (GameScreen.java)
La pantalla principal del juego que gestiona el ciclo de vida del juego.

#### Características
- Gestión de entradas del jugador
- Actualización del juego
- Renderizado completo
- Sistema de detección de gestos

#### Métodos Principales
- `render(float delta)`: Renderiza el juego
- `update(float delta)`: Actualiza el estado del juego
- `handleInput()`: Procesa entradas del jugador
- `shoot()`: Dispara un proyectil

## Control de Entrada

### PC (Teclado)
- **Movimiento**: Flechas izquierda/derecha
- **Salto**: Tecla arriba o espacio
- **Disparo**: Barra espaciadora

### Móvil (Toque)
- **Movimiento**: Deslizamiento izquierda/derecha
- **Salto**: Toque en pantalla
- **Disparo**: Toque en pantalla

## Sistema de Colisiones

El juego implementa un sistema básico de detección de colisiones:

1. **Colisiones entre jugador y enemigos**
2. **Colisiones entre balas y enemigos**
3. **Colisiones entre balas y obstáculos**

## Gestión de Recursos

### Texturas
- Carga de texturas desde archivos PNG
- Gestión de memoria para texturas
- Reutilización de recursos

### Sonido
- Carga de archivos de audio
- Reproducción de efectos de sonido
- Gestión del volumen

## Compilación y Ejecución

### Requisitos
- Java 21 o superior
- Gradle 6.0 o superior
- LibGDX 1.12.0

### Compilación
```bash
# Compilar el proyecto
./gradlew build

# Ejecutar el juego
./gradlew run
```

### Compilación para Android
```bash
# Crear archivo APK
./gradlew android:assembleDebug

# Instalar en dispositivo
./gradlew android:installDebug
```

## Consideraciones de Rendimiento

### Optimización de Gráficos
- Reutilización de texturas
- Carga eficiente de recursos
- Reducción de llamadas de renderizado

### Optimización de Memoria
- Gestión de objetos temporales
- Reciclaje de objetos
- Limpieza de recursos inactivos

## Sistema de Versiones

### Git
- El proyecto utiliza Git para control de versiones
- Ramas separadas para características y correcciones
- Tags para versiones estables

### Gradle
- Gestión de dependencias
- Automatización de procesos
- Configuración de compilación

## Pruebas

### Pruebas Unitarias
- Tests para sistemas de movimiento
- Tests para sistemas de daño
- Tests para sistemas de colisión

### Pruebas de Integración
- Pruebas del sistema completo
- Pruebas de rendimiento
- Pruebas de portabilidad

## Configuración del Entorno de Desarrollo

### Requisitos
1. Java 21 (JDK)
2. IntelliJ IDEA o Eclipse
3. Gradle 6.0+
4. LibGDX 1.12.0

### Configuración
1. Clonar el repositorio
2. Abrir en IntelliJ o Eclipse
3. Configurar el entorno de LibGDX
4. Ejecutar `./gradlew run` para iniciar el juego

## Despliegue

### PC
- Ejecutable JAR para distribución
- Compilación para diferentes sistemas operativos

### Android
- APK para dispositivos móviles
- Configuración de permisos necesarios