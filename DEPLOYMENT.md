# Guía de Despliegue para Metal Slug Clone

## Visión General

Esta guía detalla el proceso de despliegue del juego Metal Slug Clone en diferentes plataformas, incluyendo PC (Windows, macOS, Linux) y dispositivos móviles Android.

## Requisitos del Sistema

### Requisitos Mínimos

**PC (Windows, macOS, Linux)**
- Procesador: Intel i5-12600K o equivalente
- RAM: 8GB o superior
- GPU: NVIDIA GTX 1060 o equivalente
- Almacenamiento: 500MB de espacio libre
- Sistema Operativo: Windows 10/11, macOS 10.15+, Ubuntu 20.04+

**Android**
- Versión: Android 7.0 (Nougat) o superior
- RAM: 2GB o superior
- Almacenamiento: 500MB de espacio libre
- GPU: Compatible con OpenGL ES 2.0+

### Herramientas de Despliegue

- Gradle 7.0+
- Android Studio (para Android)
- JDK 21 o superior
- LibGDX 1.12.0
- Git para control de versiones

## Proceso de Despliegue

### Despliegue para PC

#### 1. Preparación del Entorno

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/metal-slug-clone.git
cd metal-slug-clone

# Verificar dependencias
./gradlew dependencies
```

#### 2. Compilación para PC

```bash
# Compilar el proyecto
./gradlew desktop:dist

# O compilar solo el ejecutable
./gradlew desktop:build
```

#### 3. Estructura del Despliegue PC

El despliegue para PC generará los siguientes archivos:
```
build/libs/
├── metal-slug-game-desktop-1.0.0.jar
├── lib/
│   ├── gdx-1.12.0.jar
│   ├── gdx-backend-lwjgl3-1.12.0.jar
│   ├── gdx-platform-1.12.0-natives-desktop.jar
│   └── otros-jars necesarios
└── ejecutable/
    └── MetalSlugGame.jar
```

#### 4. Ejecución del Juego en PC

```bash
# Ejecutar el juego
java -jar build/libs/metal-slug-game-desktop-1.0.0.jar

# O ejecutar con dependencias
java -cp "build/libs/*:lib/*" Main
```

### Despliegue para Android

#### 1. Preparación del Entorno Android

```bash
# Verificar que Android Studio esté instalado
# Configurar el SDK de Android

# Verificar que el proyecto tenga configuración de Android
./gradlew android:assembleDebug
```

#### 2. Compilación para Android

```bash
# Compilar el APK de debug
./gradlew android:assembleDebug

# Compilar el APK de release (para publicación)
./gradlew android:assembleRelease
```

#### 3. Estructura del Despliegue Android

El despliegue para Android generará los siguientes archivos:
```
build/outputs/apk/
├── debug/
│   └── metal-slug-game-debug.apk
└── release/
    └── metal-slug-game-release.apk
```

#### 4. Instalación en Dispositivo Android

```bash
# Instalar el APK en dispositivo conectado
./gradlew android:installDebug

# O instalar manualmente
adb install build/outputs/apk/debug/metal-slug-game-debug.apk
```

## Configuración de Despliegue Automático

### Script de Despliegue Automático (Linux/macOS)

```bash
#!/bin/bash
# deploy.sh

echo "Iniciando proceso de despliegue..."

# Limpiar compilación anterior
./gradlew clean

# Compilar para PC
echo "Compilando para PC..."
./gradlew desktop:build

# Compilar para Android
echo "Compilando para Android..."
./gradlew android:assembleDebug

# Crear directorio de despliegue
mkdir -p deployment/{pc,android}

# Copiar archivos de PC
cp build/libs/metal-slug-game-desktop-1.0.0.jar deployment/pc/
cp -r lib/ deployment/pc/

# Copiar APK de Android
cp build/outputs/apk/debug/metal-slug-game-debug.apk deployment/android/

echo "Despliegue completado en deployment/"
```

### Script de Despliegue Automático (Windows)

```batch
@echo off
REM deploy.bat

echo Iniciando proceso de despliegue...

REM Limpiar compilación anterior
gradlew clean

REM Compilar para PC
echo Compilando para PC...
gradlew desktop:build

REM Compilar para Android
echo Compilando para Android...
gradlew android:assembleDebug

REM Crear directorios de despliegue
mkdir deployment\pc
mkdir deployment\android

REM Copiar archivos de PC
copy build\libs\metal-slug-game-desktop-1.0.0.jar deployment\pc\
xcopy lib deployment\pc\lib /E /I

REM Copiar APK de Android
copy build\outputs\apk\debug\metal-slug-game-debug.apk deployment\android\

echo Despliegue completado en deployment\
```

## Proceso de Despliegue en Servidor de Publicación

### Para Publicación en Steam

1. **Preparar el juego para Steam:**
   - Crear directorios específicos para Steam
   - Preparar archivo de configuración
   - Crear iconos y descripciones

2. **Subir al Workshop de Steam:**
   - Usar el herramienta de publicación de Steam
   - Configurar metadatos del juego
   - Subir archivos del juego

### Para Publicación en Google Play

1. **Configurar cuenta de desarrollador:**
   - Crear cuenta de desarrollador de Google Play
   - Configurar información de la aplicación
   - Crear certificado de firma

2. **Preparar para publicación:**
   - Crear capturas de pantalla
   - Preparar descripciones
   - Configurar metadatos de la aplicación

3. **Subir a Google Play Console:**
   - Subir APK
   - Configurar información de la aplicación
   - Revisar y publicar

## Manejo de Errores Comunes

### Problemas de Compilación

**Error: "Could not resolve all dependencies"**
```bash
# Limpiar cache y recompilar
./gradlew clean
./gradlew build --refresh-dependencies
```

**Error: "Java version not supported"**
```bash
# Verificar versión de Java
java -version
# Usar versión compatible (Java 21 o superior)
```

### Problemas de Ejecución

**Error: "NoClassDefFoundError"**
```bash
# Verificar que todas las dependencias estén incluidas
java -cp "build/libs/*:lib/*" Main
```

**Error: "Could not load library"**
```bash
# Verificar que librerías nativas estén presentes
# En Linux: Asegurarse de tener libgdx nativa
```

### Problemas de Android

**Error: "APK not signed"**
```bash
# Crear firma para APK
keytool -genkey -v -keystore my-release-key.keystore -alias my-key-alias -keyalg RSA -keysize 2048 -validity 10000
```

## Verificación de Despliegue

### Verificación de PC

```bash
# Ejecutar juego en modo de prueba
java -jar build/libs/metal-slug-game-desktop-1.0.0.jar --test

# Verificar que se carguen correctamente los recursos
# Verificar que se puedan jugar niveles
```

### Verificación de Android

```bash
# Verificar instalación
adb devices

# Verificar que la aplicación se ejecuta correctamente
adb shell am start -n com.metal.slug.game/.MainActivity

# Verificar logs de error
adb logcat | grep "MetalSlug"
```

## Actualizaciones de Despliegue

### Proceso de Actualización

1. **Preparar nueva versión:**
   ```bash
   git pull origin main
   ./gradlew clean
   ```

2. **Compilar nueva versión:**
   ```bash
   ./gradlew desktop:build
   ./gradlew android:assembleRelease
   ```

3. **Desplegar nueva versión:**
   ```bash
   # Copiar archivos actualizados
   cp build/libs/metal-slug-game-desktop-1.0.0.jar deployment/pc/
   cp build/outputs/apk/release/metal-slug-game-release.apk deployment/android/
   ```

## Documentación de Despliegue

### Archivo de Configuración

**gradle.properties**
```properties
# Propiedades de compilación
org.gradle.jvmargs=-Xmx1024m
# Versión del juego
game.version=1.0.0
# Nombre del juego
game.name=Metal Slug Clone
```

### Archivo de Configuración de Recursos

**assets/config/game.properties**
```properties
# Configuración del juego
game.title=Metal Slug Clone
game.version=1.0.0
game.author=Tu Nombre
game.release.date=2026-09-05
```

## Soporte de Despliegue

### Contacto de Soporte

- **Equipo de Despliegue:** deploy@metalslug.com
- **Soporte Técnico:** support@metalslug.com
- **Documentación:** docs.metalslug.com

### Documentación Adicional

- [Guía de Desarrollo](DEVELOPMENT.md)
- [Plan de Pruebas](TEST_PLAN.md)
- [Documentación Técnica](docs/IMPLEMENTATION.md)

## Consideraciones Finales

El proceso de despliegue está diseñado para ser robusto y confiable. Es importante mantener las versiones actualizadas y seguir los procedimientos establecidos para garantizar una experiencia de usuario óptima en todas las plataformas.