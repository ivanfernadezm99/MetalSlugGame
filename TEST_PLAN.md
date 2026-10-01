# Plan de Pruebas para Metal Slug Clone

## Visión General

Este documento detalla el plan de pruebas para el juego Metal Slug Clone, asegurando que todas las funcionalidades funcionen correctamente y que el juego cumpla con los estándares de calidad esperados.

## Tipos de Pruebas

### 1. Pruebas Unitarias

#### Objetivo
Verificar que cada componente individual del juego funcione correctamente.

#### Componentes a Probar:

**Player.java**
- Movimiento horizontal (correr)
- Sistema de salto
- Sistema de vida y salud
- Control de dirección
- Sistema de invencibilidad

**Enemy.java**
- Movimiento básico de enemigos
- Sistema de vida y salud
- Estado de vida (activo/muerto)
- Comportamiento básico de IA

**Weapon.java**
- Movimiento lineal de proyectiles
- Sistema de vida activa/inactiva
- Sistema de daño
- Detección de colisiones

**Level.java**
- Gestión de elementos del nivel
- Sistema de renderizado
- Actualización de objetos del nivel
- Sistema de gestión de enemigos y proyectiles

### 2. Pruebas de Integración

#### Objetivo
Verificar que los componentes trabajen juntos correctamente.

#### Áreas a Probar:

**Sistema de Jugador y Enemigos**
- Colisiones jugador-enemigo
- Sistema de daño
- Sistema de salud

**Sistema de Jugador y Armas**
- Disparo del jugador
- Proyectiles disparados por el jugador
- Sistema de recarga

**Sistema de Nivel**
- Gestión de objetos en niveles
- Sistema de renderizado
- Colisiones en niveles

### 3. Pruebas de Rendimiento

#### Objetivo
Verificar el rendimiento del juego en diferentes plataformas.

#### Métricas a Evaluar:

**PC (Desktop)**
- FPS (Frames Per Second)
- Uso de CPU
- Uso de memoria
- Tiempo de carga

**Móvil (Android)**
- FPS
- Uso de CPU
- Uso de memoria
- Consumo de batería

### 4. Pruebas de Usabilidad

#### Objetivo
Verificar la experiencia de usuario y facilidad de uso.

#### Criterios a Evaluar:

**Controles**
- Responsividad de controles
- Intuitividad de controles
- Adaptación a diferentes plataformas

**Interfaz de Usuario**
- Claridad de elementos de UI
- Disponibilidad de información
- Diseño atractivo

**Jugabilidad**
- Fluidez del juego
- Balance de dificultad
- Experiencia general

## Casos de Prueba Detallados

### Caso 1: Movimiento del Jugador

**ID:** TC001
**Descripción:** Verificar que el jugador se mueva correctamente

**Precondiciones:**
- Juego iniciado
- Jugador creado

**Pasos:**
1. Presionar flecha izquierda
2. Verificar movimiento a la izquierda
3. Presionar flecha derecha
4. Verificar movimiento a la derecha
5. Presionar espacio (salto)
6. Verificar salto

**Resultado Esperado:**
- El jugador se mueve en la dirección correcta
- El salto funciona correctamente

### Caso 2: Sistema de Salud

**ID:** TC002
**Descripción:** Verificar sistema de vida y salud del jugador

**Precondiciones:**
- Juego iniciado
- Jugador creado con salud inicial

**Pasos:**
1. Recibir daño del enemigo
2. Verificar reducción de salud
3. Verificar si el jugador muere cuando salud <= 0
4. Verificar sistema de vida

**Resultado Esperado:**
- El jugador pierde salud cuando recibe daño
- El jugador muere cuando salud llega a 0
- Sistema de vida funciona correctamente

### Caso 3: Sistema de Disparo

**ID:** TC003
**Descripción:** Verificar sistema de disparo del jugador

**Precondiciones:**
- Juego iniciado
- Jugador con armas disponibles

**Pasos:**
1. Presionar barra espaciadora
2. Verificar creación de proyectil
3. Verificar movimiento del proyectil
4. Verificar colisión con enemigo

**Resultado Esperado:**
- El jugador dispara proyectiles
- Los proyectiles se mueven correctamente
- Los proyectiles eliminan enemigos

### Caso 4: Sistema de Enemigos

**ID:** TC004
**Descripción:** Verificar comportamiento de enemigos

**Precondiciones:**
- Juego iniciado
- Enemigos creados

**Pasos:**
1. Verificar movimiento del enemigo
2. Verificar sistema de vida
3. Verificar eliminación cuando salud <= 0
4. Verificar comportamiento IA

**Resultado Esperado:**
- Los enemigos se mueven correctamente
- Los enemigos tienen salud
- Los enemigos se eliminan cuando su salud llega a 0
- Los enemigos siguen comportamientos básicos de IA

### Caso 5: Sistema de Colisiones

**ID:** TC005
**Descripción:** Verificar sistema de detección de colisiones

**Precondiciones:**
- Juego iniciado
- Jugador y enemigos creados

**Pasos:**
1. Hacer que el jugador choque con un enemigo
2. Verificar daño al jugador
3. Hacer que un proyectil choque con un enemigo
4. Verificar eliminación del enemigo

**Resultado Esperado:**
- El jugador recibe daño al chocar con enemigos
- Los enemigos se eliminan al ser alcanzados por proyectiles
- Sistema de colisiones funciona correctamente

### Caso 6: Sistema de Nivel

**ID:** TC006
**Descripción:** Verificar sistema de gestión de niveles

**Precondiciones:**
- Juego iniciado
- Nivel creado con elementos

**Pasos:**
1. Verificar renderizado del fondo
2. Verificar renderizado de enemigos
3. Verificar renderizado de proyectiles
4. Verificar actualización del nivel

**Resultado Esperado:**
- El fondo se renderiza correctamente
- Los enemigos se renderizan
- Los proyectiles se renderizan
- El nivel se actualiza correctamente

### Caso 7: Sistema de Entrada

**ID:** TC007
**Descripción:** Verificar sistema de entrada

**Precondiciones:**
- Juego iniciado
- Controles configurados

**Pasos:**
1. Probar controles de teclado en PC
2. Probar controles táctiles en móvil
3. Verificar reacción de jugador a entradas
4. Verificar sistema de pausa

**Resultado Esperado:**
- Los controles funcionan correctamente
- El jugador responde a las entradas
- El sistema de pausa funciona
- Los controles son intuitivos

### Caso 8: Sistema de Renderizado

**ID:** TC008
**Descripción:** Verificar sistema de renderizado

**Precondiciones:**
- Juego iniciado
- Elementos de juego creados

**Pasos:**
1. Verificar renderizado de jugador
2. Verificar renderizado de enemigos
3. Verificar renderizado de proyectiles
4. Verificar renderizado de fondo

**Resultado Esperado:**
- Todos los elementos se renderizan correctamente
- No hay glitches visuales
- El rendimiento es aceptable

## Pruebas de Rendimiento

### Prueba de FPS (Frames Per Second)

**Criterios de Evaluación:**
- Mínimo de 30 FPS en PC
- Mínimo de 30 FPS en dispositivos móviles
- Consistencia de FPS durante el juego

**Métricas:**
- FPS promedio durante 30 segundos de juego
- FPS mínimo durante el juego
- FPS máximo durante el juego

### Prueba de Uso de Recursos

**Criterios de Evaluación:**
- Uso de CPU < 70% en PC
- Uso de memoria < 512MB en PC
- Uso de CPU < 80% en móvil
- Uso de memoria < 256MB en móvil

## Pruebas de Usabilidad

### Prueba de Facilidad de Uso

**Criterios de Evaluación:**
- Tiempo promedio para entender controles (≤5 minutos)
- Nivel de satisfacción del jugador (≥8/10)
- Completitud del tutorial (100% completado)

### Prueba de Accesibilidad

**Criterios de Evaluación:**
- Soporte para diferentes configuraciones de controles
- Compatibilidad con dispositivos de accesibilidad
- Clarity de elementos de UI

## Entorno de Pruebas

### Hardware de Pruebas

**PC (Windows, macOS, Linux)**
- Procesador: Intel i5-12600K o equivalente
- RAM: 16GB o superior
- GPU: NVIDIA GTX 1060 o equivalente
- Almacenamiento: SSD de 256GB o superior

**Dispositivos Móviles**
- Android 7.0 o superior
- Procesador: Snapdragon 855 o equivalente
- RAM: 4GB o superior
- Almacenamiento: 64GB o superior

### Software de Pruebas

**Herramientas de Pruebas:**
- JUnit para pruebas unitarias
- Mockito para simulación de objetos
- Android Profiler para pruebas móviles
- LibGDX tools para pruebas específicas

### Configuración de Pruebas

**Configuración por Defecto:**
- Resolución: 800x600
- Calidad gráfica: Media
- Sonido: Habilitado
- Controles: Configuración por defecto

## Procedimiento de Prueba

### 1. Preparación de Pruebas

1. Configurar entorno de prueba
2. Instalar versión de prueba
3. Configurar herramientas de monitoreo
4. Documentar configuraciones

### 2. Ejecución de Pruebas

1. Ejecutar pruebas unitarias
2. Ejecutar pruebas de integración
3. Ejecutar pruebas de rendimiento
4. Ejecutar pruebas de usabilidad

### 3. Análisis de Resultados

1. Registrar todos los resultados
2. Identificar errores y problemas
3. Documentar casos de prueba fallidos
4. Evaluar rendimiento

### 4. Reporte de Resultados

1. Generar informe de pruebas
2. Documentar problemas encontrados
3. Recomendar mejoras
4. Establecer prioridades de corrección

## Métricas de Éxito

### Métricas de Calidad

**Cobertura de Código:**
- Mínimo del 80% de código cubierto por pruebas
- Cobertura de funcionalidades críticas del 100%

**Tasa de Éxito de Pruebas:**
- ≥ 95% de pruebas exitosas
- ≤ 5% de pruebas fallidas

### Métricas de Rendimiento

**FPS:**
- ≥ 30 FPS en PC
- ≥ 30 FPS en móvil

**Uso de Recursos:**
- CPU < 80% en PC
- Memoria < 512MB en PC
- CPU < 90% en móvil
- Memoria < 256MB en móvil

## Documentación de Resultados

### Informe de Pruebas

**Contenido del Informe:**
- Resumen ejecutivo
- Detalles de pruebas ejecutadas
- Resultados de pruebas
- Análisis de errores
- Recomendaciones
- Criterios de aceptación

### Registro de Errores

**Formato del Registro:**
- ID del error
- Descripción del error
- Pasos para reproducir
- Entorno de prueba
- Prioridad
- Estado de corrección

## Plan de Corrección

### Errores Críticos

**Definición:** Errores que impiden el funcionamiento básico del juego

**Acción:**
- Prioridad inmediata de corrección
- Re-prueba inmediata después de corrección
- Verificación de impacto en otros componentes

### Errores de Alta Prioridad

**Definición:** Errores que afectan la experiencia de usuario

**Acción:**
- Corrección dentro de 48 horas
- Re-prueba después de corrección
- Verificación de impacto en otros componentes

### Errores de Baja Prioridad

**Definición:** Errores que no afectan funcionalidad principal

**Acción:**
- Corrección en próxima versión
- Documentación del error para seguimiento

## Criterios de Aceptación

### Funcionales

1. El jugador puede moverse y saltar correctamente
2. El sistema de disparo funciona
3. Los enemigos se mueven y pueden ser eliminados
4. El sistema de colisiones funciona correctamente
5. La interfaz de usuario es funcional
6. El juego funciona en todas las plataformas

### De Rendimiento

1. FPS mínimo de 30 en PC
2. FPS mínimo de 30 en móvil
3. Uso de recursos dentro de límites aceptables
4. Tiempo de carga razonable

### De Calidad

1. Sin errores críticos
2. Sin errores de alta prioridad
3. Rendimiento estable
4. Experiencia de usuario satisfactoria

## Seguimiento

El plan de pruebas se ejecutará en ciclos de 2 semanas, con revisiones semanales para asegurar que todos los objetivos se cumplan. Los resultados se documentarán y se utilizarán para mejorar el juego antes del lanzamiento final.