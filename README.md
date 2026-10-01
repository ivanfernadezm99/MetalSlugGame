# Metal Slug Clone Game

A 2D Metal Slug style game clone implemented with LibGDX framework using Java 21 modernization.

## Features

- Fully implemented enemy AI with state machines
- Object pooling for performance optimization
- Particle effects system
- Cross-platform compatibility (Android and PC)
- Enhanced performance with Java 21

## Project Structure

```
MetalSlugGame/
├── src/
│   └── com/metal/slug/
│       ├── game/           # Main game classes
│       ├── player/            # Player implementation
│       ├── enemy/             # Enemy AI and implementation
│       ├── weapon/      # Weapon system
│       ├── level/         # Level management
│       ├── collision/   # Collision detection
│       ├── input/          # Input handling
│       ├── graphics/       # Graphics and resource management
│       └── particle/    # Particle effects
├── assets/
│   ├── sprites/             # Sprite assets
│   ├── textures/              # Texture assets
│   ├── sounds/          # Sound effects
│   └── levels/     # Level data
├── android/                 # Android-specific code
└── build.gradle            # Build configuration
```

## Java 21 Modernization

The project has been modernized to use Java 21 with:
- Toolchain support for compilation
- Enhanced performance optimization techniques
- Modern code patterns

## Enemy AI Implementation

The enemy AI uses a finite state machine with the following states:
- IDLE: Enemy is idle
- PATROL: Enemy is patrolling
- CHASE: Enemy is chasing the player
- ATTACK: Enemy is attacking
- HURT: Enemy is taking damage
- DEAD: Enemy is dead

## Performance Optimization

- Object pooling to prevent GC pauses on mobile devices
- Efficient resource management
- Particle system with pooling

## Building and Running

### Requirements
- Java 21
- Gradle 7.0+
- Android SDK 33 (for Android builds)

### Building for PC
```
./gradlew desktop:run
```

### Building for Android
```
./gradlew android:assembleDebug
```

### Building APK
```
./gradlew android:assembleRelease
```

## Assets

The game requires sprite assets to be placed in the `assets/sprites/` directory:
- Player sprites
- Enemy sprites
- Projectile sprites
- UI elements

Please add the required sprite assets to the appropriate directories in the assets folder.