# Guía de Contribución

## Visión General

¡Bienvenido al proyecto Metal Slug Clone! Esta guía está diseñada para ayudarte a contribuir al desarrollo del juego. Ya seas un desarrollador experimentado o alguien nuevo en el proyecto, esta guía te proporcionará las herramientas y directrices necesarias para participar eficazmente.

## Cómo Contribuir

### Reporte de Problemas

Si encuentras un error o problema en el juego:

1. **Verifica si el problema ya está reportado** en la sección de Issues
2. **Crea un nuevo Issue** con una descripción clara del problema
3. **Incluye información sobre tu entorno** (sistema operativo, versión del juego, etc.)
4. **Proporciona pasos para reproducir el problema**

### Propuestas de Funcionalidades

Para proponer una nueva característica:

1. **Abre un Issue** describiendo la funcionalidad deseada
2. **Incluye la motivación** detrás de la propuesta
3. **Explica cómo beneficiaría al juego**
4. **Considera el impacto** en el rendimiento y el diseño

### Envío de Código

Para enviar código al proyecto:

1. **Haz un fork del repositorio**
2. **Crea una rama feature desde develop**
3. **Implementa tu cambio**
4. **Escribe pruebas si es apropiado**
5. **Documenta tu código**
6. **Abre un Pull Request**

## Proceso de Desarrollo

### Ramas y Versiones

```
main              # Rama estable (versión final)
develop           # Rama de desarrollo (versión en desarrollo)
feature/*         # Ramas para nuevas características
bugfix/*          # Ramas para correcciones de errores
release/*       # Ramas para lanzamientos
hotfix/*          # Ramas para correcciones urgentes
```

### Convenciones de Commits

Los mensajes de commit deben seguir el estándar de **Conventional Commits**:

```
<tipo>[opcional ámbito]: <descripción>

[corpo opcional]

[referencias]
```

#### Tipos de Commits

- **feat**: Nueva funcionalidad
- **fix**: Corrección de errores
- **docs**: Cambios en documentación
- **style**: Cambios de estilo (formato, sin impacto en el código)
- **refactor**: Refactorización de código
- **test**: Adición o corrección de pruebas
- **chore**: Cambios de mantenimiento

#### Ejemplos

```
feat: Agregar sistema de disparo automático

Agrega la capacidad de disparo automático al jugador con un sistema de recarga

Closes #123
```

```
fix: Corregir colisión de jugador-enemigo

El jugador ahora colisiona correctamente con enemigos en todos los casos

Fixes #456
```

## Estructura del Proyecto

### Directorios Principales

```
MetalSlugGame/
├── src/                    # Código fuente
├── assets/                   # Recursos del juego
├── docs/                     # Documentación técnica
├── tests/                    # Pruebas unitarias
├── build/                    # Archivos de compilación
├── gradle/                   # Configuración de Gradle
├── scripts/                # Scripts de automatización
└── .github/                 # Configuración de GitHub
```

### Estructura de Código

#### Directorio de Entidades

```
src/
└── com.metal.slug.game/
    ├── core/              # Lógica principal del juego
    ├── entities/            # Entidades del juego (jugador, enemigos, etc.)
    ├── screens/            # Pantallas del juego
    ├── systems/          # Sistemas del juego (colisiones, física, etc.)
    ├── utils/              # Utilidades y clases auxiliares
    └── managers/           # Gestores (recursos, entrada, etc.)
```

## Procedimiento de Desarrollo

### 1. Configuración del Entorno

1. **Clonar el repositorio**
```bash
git clone https://github.com/tu-usuario/metal-slug-clone.git
cd metal-slug-clone
```

2. **Instalar dependencias**
```bash
./gradlew dependencies
```

3. **Configurar el IDE**
- Abrir en IntelliJ IDEA o Eclipse
- Importar como proyecto Gradle
- Configurar variables de entorno

### 2. Creación de una Nueva Funcionalidad

1. **Crear rama feature**
```bash
git checkout -b feature/nueva-funcionalidad develop
```

2. **Implementar la funcionalidad**
```java
// Ejemplo: Nueva clase para sistema de armas
public class WeaponSystem {
    // Implementación
}
```

3. **Escribir pruebas**
```java
public class WeaponSystemTest {
    @Test
    public void testWeaponFire() {
        // Prueba de disparo
    }
}
```

4. **Documentar**
```java
/**
 * Sistema de armas para el jugador
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class WeaponSystem {
    // Documentación del código
}
```

5. **Compilar y probar**
```bash
./gradlew build test
```

### 3. Preparación para Envío

1. **Ejecutar pruebas completas**
```bash
./gradlew test
```

2. **Verificar cobertura de código**
```bash
./gradlew jacocoTestReport
```

3. **Actualizar documentación**
- Actualizar README si aplica
- Actualizar docs/IMPLEMENTATION.md si aplica

4. **Hacer commit**
```bash
git add .
git commit -m "feat: Agregar sistema de armas"
```

## Código de Conducta

### Nuestro Compromiso

Nosotros, como contribuyentes y mantenedores, nos comprometemos a hacer que la participación en nuestro proyecto y nuestra comunidad sea una experiencia libre de acoso para todos, independientemente de la edad, apariencia física, discapacidad, etnia, identidad y expresión de género, nivel de experiencia, nacionalidad, apariencia personal, raza, religión o identidad y orientación sexual.

### Nuestros Estándares

Ejemplos de comportamiento que contribuyen a crear un ambiente positivo:

- Usar un lenguaje acogedor e inclusivo
- Respetar diferentes puntos de vista y experiencias
- Aceptar críticas constructivas
- Enfocarse en lo que es mejor para la comunidad
- Mostrar empatía hacia otros miembros de la comunidad

Ejemplos de comportamiento inaceptable:

- El uso de lenguaje o imágenes sexualizadas, y atención o avances sexuales no deseados
- Trolling, comentarios ofensivos o derogatorios, y ataques personales o políticos
- Acoso público o privado
- Publicar información privada de otros, como direcciones físicas o electrónicas
- Otros comportamientos que puedan ser considerados inapropiados en un entorno profesional

## Procedimiento de Resolución de Conflictos

### Reporte de Problemas

Si encuentras un problema con este código de conducta, por favor contacta a los mantenedores del proyecto a través de [email].

### Medidas de Acción

Los mantenedores del proyecto tomarán las medidas necesarias para responder a cualquier instancia de comportamiento inaceptable. Esto puede incluir:

1. Eliminar comentarios o contribuciones
2. Bloquear temporalmente o permanentemente a usuarios
3. Publicar advertencias públicas
4. Otros remedios apropiados según la situación

## Agradecimientos

¡Gracias por contribuir a Metal Slug Clone! Tu participación hace que este proyecto sea aún mejor.

## Contacto

Para preguntas o aclaraciones, por favor contacta a los mantenedores del proyecto en [email] o a través de los Issues del repositorio.

## Licencia

Al contribuir a este proyecto, aceptas que tu trabajo esté licenciado bajo la [licencia del proyecto]. Tu contribución se considerará parte de los derechos de autor del proyecto.

## Versión Actual

Esta guía se basa en la versión 1.0 del proyecto Metal Slug Clone.