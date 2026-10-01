# Especificaciones Técnicas - Metal Slug Clone

## Visión General

Este documento detalla las especificaciones técnicas del sistema de juego Metal Slug Clone, incluyendo los componentes principales del juego y sus funcionalidades específicas.

## 1. Especificaciones de Diseño del Jugador

### 1.1. Características Principales

**Movimiento del Jugador**
- Velocidad de carrera: 300 pixels/segundo
- Velocidad de salto: 500 pixels/segundo
- Gravedad: 9.8 pixels/segundo²
- Sistema de salto único por suelo (no doble salto)
- Control de dirección (izquierda/derecha)

**Sistema de Vida y Salud**
- Vidas iniciales: 3
- Sistema de invencibilidad: 2 segundos tras recibir daño
- Sistema de salud: 100 puntos de salud
- Sistema de daño: Reducción de salud al recibir disparos

**Sistema de Armas**
- Arma principal: Pistola con 200 balas
- Sistema de recarga automática
- Sistema de municiones: 10 granadas explosivas
- Sistema de armas secundarias: Ametralladora, Lanzacohetes

### 1.2. Especificaciones Técnicas

**Clase Player**
```java
public class Player {
    private Vector2 position;        // Posición actual
    private Vector2 velocity;        // Velocidad actual
    private int health;          // Puntos de salud (0-100)
    private int lives;           // Vidas restantes
    private boolean isJumping;   // Estado de salto
    private boolean facingRight;     // Dirección de mirada
    private float speed;              // Velocidad de movimiento
    private float jumpForce;      // Fuerza de salto
    private boolean isInvincible; // Estado de invencibilidad
    private long invincibleTimer; // Temporizador de invencibilidad
    
    // Métodos principales
    public void update(float deltaTime);
    public void render(SpriteBatch batch);
    public void moveLeft();
    public void moveRight();
    public void jump();
    public void shoot();
    public void takeDamage(int damage);
}
```

**Sistema de Movimiento**
- Sistema de física basado en Newton
- Colisión con obstáculos
- Sistema de gravedad
- Control de salto con restricciones

### 1.3. Comportamiento del Jugador

**Movimiento Horizontal**
- Correr a velocidad máxima
- Fricción al detenerse
- Aceleración y desaceleración

**Salto**
- Impulso vertical
- Control de altura de salto
- Límite de salto en el aire

**Disparo**
- Sistema de disparo automático
- Recarga automática
- Sistema de balas limitadas

## 2. Especificaciones del Sistema de Enemigos

### 2.1. Tipos de Enemigos

**Enemigo Básico**
- Vida: 50 puntos de salud
- Movimiento: Patrullaje básico
- Comportamiento: Seguir ruta predefinida
- Daño: 10 puntos al impactar

**Enemigo Avanzado**
- Vida: 100 puntos de salud
- Movimiento: Patrullaje con patrón de movimiento
- Comportamiento: Atacar al jugador
- Daño: 20 puntos al impactar

**Jefe Final**
- Vida: 500 puntos de salud
- Movimiento: Patrullaje complejo
- Comportamiento: Múltiples patrones de ataque
- Daño: 30 puntos al impactar

### 2.2. Especificaciones Técnicas

**Clase Enemy**
```java
public class Enemy {
    private Vector2 position;    // Posición actual
    private Vector2 velocity;    // Velocidad actual
    private int health;              // Puntos de salud
    private EnemyType type;      // Tipo de enemigo
    private boolean isAlive;         // Estado de vida
    private float speed;            // Velocidad de movimiento
    private int damage;        // Daño que causa
    private EnemyAI ai;           // Sistema de IA
    
    // Métodos principales
    public void update(float deltaTime);
    public void render(SpriteBatch batch);
    public void takeDamage(int damage);
    public void move();
    public void attack();
}
```

**Sistema de IA Básico**
- Detección de jugador
- Movimiento hacia jugador
- Ataques básicos
- Patrullaje

### 2.3. Comportamiento de Enemigos

**Comportamiento de Patrullaje**
- Movimiento predefinido
- Detección de jugador en rango
- Cambio de comportamiento

**Comportamiento de Ataque**
- Seguimiento del jugador
- Ataques en línea recta
- Tiempo de espera entre ataques

## 3. Especificaciones del Sistema de Armas

### 3.1. Tipos de Armas

**Pistola (Primaria)**
- Daño: 25 puntos
- Recarga: Automática
- Balas: 200
- Velocidad de disparo: 200 balas/segundo
- Rango: 500 pixels

**Ametralladora (Secundaria)**
- Daño: 15 puntos
- Recarga: Automática
- Balas: 500
- Velocidad de disparo: 500 balas/segundo
- Rango: 400 pixels

**Lanzacohetes (Especial)**
- Daño: 50 puntos
- Recarga: Manual (1 cada 30 segundos)
- Balas: 10
- Velocidad de disparo: 100 pixels/segundo
- Rango: 800 pixels

### 3.2. Especificaciones Técnicas

**Clase Weapon**
```java
public class Weapon {
    private WeaponType type;        // Tipo de arma
    private int damage;              // Daño del proyectil
    private int ammo;                // Cantidad de municiones
    private float fireRate;            // Frecuencia de disparo
    private float range;               // Rango de disparo
    private boolean isAutomatic;   // Sistema automático
    
    // Métodos principales
    public void shoot(Vector2 position, Vector2 direction);
    public void reload();
    public boolean canShoot();
}
```

### 3.3. Comportamiento del Sistema de Armas

**Sistema de Recarga**
- Recarga automática para armas primarias
- Recarga manual para armas especiales
- Sistema de municiones limitado

**Sistema de Disparo**
- Sistema de disparo automático
- Sistema de disparo por clic
- Sistema de balas limitadas

## 4. Especificaciones del Sistema de Niveles

### 4.1. Componentes del Nivel

**Fondo de Nivel**
- Imágenes de fondo con capas de parallax
- Objetos decorativos
- Elementos de ambiente

**Obstáculos**
- Muros y bloques
- Obstáculos físicos
- Elementos interactivos

**Puntos de Interés**
- Puntos de inicio del jugador
- Puntos de fin de nivel
- Objetos recolectables

### 4.2. Especificaciones Técnicas

**Clase Level**
```java
public class Level {
    private String name;            // Nombre del nivel
    private int width;          // Ancho del nivel
    private int height;           // Alto del nivel
    private Texture background; // Textura del fondo
    private List<Obstacle> obstacles; // Lista de obstáculos
    private List<Enemy> enemies;     // Lista de enemigos
    private Vector2 playerStart;      // Punto de inicio del jugador
    
    // Métodos principales
    public void update(float deltaTime);
    public void render(SpriteBatch batch);
    public void loadLevel(String levelFile);
    public boolean isCollision(Vector2 position, float radius);
}
```

### 4.3. Sistema de Carga de Niveles

**Formato de Archivo**
- Archivos de nivel en formato JSON
- Definición de objetos y enemigos
- Configuración de obstáculos
- Puntos de inicio y fin

## 5. Especificaciones del Sistema de Colisiones

### 5.1. Tipos de Colisiones

**Colisión de Jugador-Obstáculo**
- Sistema de detección de colisiones
- Sistema de respuesta a colisiones
- Sistema de rebote

**Colisión de Jugador-Enemigo**
- Sistema de detección de colisiones
- Sistema de daño
- Sistema de invencibilidad

**Colisión de Proyectil-Obstáculo**
- Sistema de detección de colisiones
- Sistema de destrucción de proyectiles
- Sistema de colisión con obstáculos

### 5.2. Especificaciones Técnicas

**Clase CollisionManager**
```java
public class CollisionManager {
    public boolean checkPlayerEnemyCollision(Player player, Enemy enemy);
    public boolean checkPlayerObstacleCollision(Player player, Obstacle obstacle);
    public boolean checkProjectileEnemyCollision(Projectile projectile, Enemy enemy);
    public boolean checkProjectileObstacleCollision(Projectile projectile, Obstacle obstacle);
    public void handleCollisions();
}
```

## 6. Especificaciones del Sistema de Controles

### 6.1. Controles para PC

**Movimiento**
- Flecha izquierda: Mover a la izquierda
- Flecha derecha: Mover a la derecha
- Flecha arriba: Saltar
- Espacio: Disparar

**Sistema de Armas**
- Tecla 1: Seleccionar Pistola
- Tecla 2: Seleccionar Ametralladora
- Tecla 3: Seleccionar Lanzacohetes

### 6.2. Controles para Android

**Movimiento**
- Botón izquierdo: Mover a la izquierda
- Botón derecho: Mover a la derecha
- Botón superior: Saltar
- Botón de disparo: Disparar

**Sistema de Armas**
- Botones laterales: Seleccionar armas

## 7. Especificaciones del Sistema de Gráficos

### 7.1. Recursos Gráficos

**Sprites del Jugador**
- Sprite de jugador en estado normal
- Sprite de jugador en estado de salto
- Sprite de jugador en estado de disparo

**Sprites de Enemigos**
- Sprite de enemigo básico
- Sprite de enemigo avanzado
- Sprite de jefe final

**Sprites de Armas**
- Sprite de pistola
- Sprite de ametralladora
- Sprite de lanzacohetes

### 7.2. Sistema de Renderizado

**Clase GameRenderer**
```java
public class GameRenderer {
    public void renderGame(GameScreen screen);
    public void renderPlayer(Player player);
    public void renderEnemies(List<Enemy> enemies);
    public void renderProjectiles(List<Projectile> projectiles);
    public void renderBackground(Level level);
}
```

## 8. Especificaciones del Sistema de Sonido

### 8.1. Efectos de Sonido

**Sonidos de Jugador**
- Sonido de disparo
- Sonido de salto
- Sonido de daño

**Sonidos de Enemigos**
- Sonido de disparo
- Sonido de daño
- Sonido de muerte

### 8.2. Música

**Música del Nivel**
- Música de fondo para cada nivel
- Cambio de música según el estado del juego

## 9. Especificaciones de Rendimiento

### 9.1. Optimización

**Detección de Colisiones**
- Sistema de culling para objetos fuera de pantalla
- Sistema de detección de colisiones eficiente

**Carga de Recursos**
- Sistema de carga de texturas por demanda
- Sistema de cacheo de recursos

## 10. Especificaciones de Pruebas

### 10.1. Pruebas Unitarias

**Pruebas de Sistema de Jugador**
- Pruebas de movimiento
- Pruebas de salto
- Pruebas de disparo

**Pruebas de Sistema de Enemigos**
- Pruebas de IA
- Pruebas de movimiento
- Pruebas de ataque

### 10.2. Pruebas de Integración

**Pruebas de Sistema de Nivel**
- Pruebas de carga de niveles
- Pruebas de colisiones
- Pruebas de sistema de obstáculos

## 11. Especificaciones de Implementación

### 11.1. Estructura del Proyecto

**Estructura de Paquetes**
- `com.metal.slug.game` - Clases principales del juego
- `com.metal.slug.player` - Sistema de jugador
- `com.metal.slug.enemy` - Sistema de enemigos
- `com.metal.slug.weapon` - Sistema de armas
- `com.metal.slug.level` - Sistema de niveles
- `com.metal.slug.collision` - Sistema de colisiones
- `com.metal.slug.input` - Sistema de controles
- `com.metal.slug.graphics` - Sistema de gráficos
- `com.metal.slug.audio` - Sistema de sonido

### 11.2. Configuración del Entorno

**Requisitos del Sistema**
- Java 21
- LibGDX 1.12.0
- Gradle 6.0+
- Entorno de desarrollo configurado

**Configuración de Compilación**
- Archivo build.gradle
- Configuración de recursos
- Configuración de dependencias