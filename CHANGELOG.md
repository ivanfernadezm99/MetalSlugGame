# Registro de Cambios

Todos los cambios notables en este proyecto se documentarán en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.3] - 2026-09-05

### Correcciones de Seguridad
- Corregida vulnerabilidad de inyección en el sistema de guardado (CVE-2026-XXXX)
- Mejorada la protección contra ataques de fuerza bruta en el sistema de autenticación

### Mejoras de Rendimiento
- Optimizado el sistema de renderizado para mejor rendimiento en dispositivos móviles
- Mejorada la gestión de memoria para reducir el uso de recursos
- Optimizado el sistema de colisiones para menor latencia

### Mejoras de Usabilidad
- Implementada nueva interfaz de usuario más intuitiva
- Mejorada la navegación en el menú principal
- Añadido sistema de configuración de controles personalizables

### Correcciones de Bug
- Corregido problema con el sistema de disparo en ciertos dispositivos
- Solucionada la inconsistencia en el movimiento del jugador
- Arreglado error en la detección de colisiones con objetos específicos

## [1.0.2] - 2026-09-04

### Nuevas Funcionalidades
- Añadido sistema de sonido con efectos de audio
- Implementado sistema de música de fondo
- Añadidos efectos de sonido para disparos y colisiones

### Mejoras de Rendimiento
- Mejorado el sistema de carga de recursos
- Optimizado el uso de CPU en dispositivos móviles
- Reducido el tiempo de inicio del juego

### Correcciones de Bug
- Corregido problema con la visualización de sprites en ciertas resoluciones
- Solucionado error en el sistema de vida del jugador
- Arreglado problema con el sistema de puntuaciones

## [1.0.1] - 2026-09-03

### Nuevas Funcionalidades
- Añadido sistema de niveles múltiples
- Implementado sistema de puntuación con tablas de líderes
- Añadida opción de pausa durante el juego

### Mejoras de Rendimiento
- Optimizado el sistema de renderizado
- Mejorada la gestión de recursos
- Reducido el uso de memoria

### Correcciones de Bug
- Corregido problema de colisión con enemigos
- Solucionado error en el sistema de disparo
- Arreglado problema con el movimiento del jugador

## [1.0.0] - 2026-09-02

### Nuevas Funcionalidades
- Versión inicial del juego Metal Slug Clone
- Implementación del sistema básico de jugador
- Añadido sistema de enemigos con comportamiento básico
- Implementado sistema de armas y proyectiles
- Sistema de niveles básico con fondos y obstáculos

### Características Principales
- Movimiento del jugador (correr, saltar, disparar)
- Sistema de vida y salud
- Sistema de colisiones
- Interfaz de usuario básica
- Soporte multiplataforma (PC y Android)
- Sistema de renderizado 2D

### Mejoras de Rendimiento
- Sistema de pool de objetos para optimizar memoria
- Gestión eficiente de recursos gráficos
- Sistema de cámara adaptativo

### Correcciones de Bug
- Corregido problema con el sistema de entrada
- Solucionado error en la detección de colisiones
- Arreglado problema con el sistema de renderizado

## [0.9.5] - 2026-08-30

### Desarrollo Continuado
- Desarrollo de la estructura base del juego
- Implementación del sistema de jugador
- Creación de estructura de clases para enemigos
- Desarrollo del sistema de armas

### Pruebas Iniciales
- Pruebas unitarias para componentes básicos
- Pruebas de integración básica
- Evaluación de rendimiento inicial

## [0.9.0] - 2026-08-25

### Pre-Release
- Configuración del entorno de desarrollo
- Estructura inicial del proyecto
- Configuración del sistema de compilación
- Inicio del desarrollo de componentes principales

### Documentación
- Creación de documentación inicial
- Configuración del sistema de control de versiones
- Establecimiento de convenciones de código

## [0.1.0] - 2026-08-20

### Inicio del Proyecto
- Inicio del desarrollo del juego Metal Slug Clone
- Establecimiento del repositorio inicial
- Configuración de herramientas de desarrollo
- Creación de estructura base del proyecto

### Objetivos Iniciales
- Implementar sistema básico de juego
- Crear estructura de clases principal
- Establecer base del sistema de renderizado
- Configurar sistema de control de versiones

---

## Guía de Versionado

Este proyecto sigue Semantic Versioning 2.0.0:

- **Versión Mayor (X.0.0)**: Cambios incompatibles
- **Versión Menor (0.X.0)**: Nuevas funcionalidades compatibles
- **Versión de Parche (0.0.X)**: Correcciones de errores

## Convenciones de Commits

Los commits siguen las convenciones de Conventional Commits:

### Tipos de Commits
- **feat**: Nueva funcionalidad
- **fix**: Corrección de errores
- **docs**: Cambios en documentación
- **style**: Cambios de estilo (formato, sin impacto en el código)
- **refactor**: Refactorización del código
- **test**: Adición o corrección de pruebas
- **chore**: Cambios de mantenimiento

### Ejemplo de Commits
```
feat: Añadir sistema de disparo automático
fix: Corregir colisión de jugador-enemigo
docs: Actualizar README con instrucciones de instalación
```

## Notas de Versión

### Versiones Estables
Las versiones marcadas como estables estarán etiquetadas con el formato `vX.Y.Z`.

### Versiones de Desarrollo
Las versiones en desarrollo estarán etiquetadas como `vX.Y.Z-dev`.

### Versiones de Pre-Lanzamiento
Las versiones de pre-lanzamiento estarán etiquetadas como `vX.Y.Z-rc.N`.