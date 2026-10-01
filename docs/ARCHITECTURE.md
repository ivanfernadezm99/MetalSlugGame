# Metal Slug Clone - Architecture

## Overview
This document describes the architectural design of the Metal Slug Clone game, including the main components, their interactions, and the overall system structure.

## System Architecture

### Core Components
1. **Game Engine** - Main game loop and state management
2. **Player System** - Player movement, physics, and controls
3. **Enemy System** - AI-driven enemies with behaviors
4. **Weapon System** - Different weapon types and projectile management
5. **Level System** - Level loading, obstacles, and environment
6. **Collision System** - Physics and collision detection
7. **Audio System** - Sound effects and music management
8. **Graphics System** - Rendering and visual effects
9. **UI System** - User interface components
10. **Save System** - Game state persistence

### Technology Stack
- **Main Language**: Java
- **Game Engine**: LibGDX
- **Graphics**: OpenGL ES
- **Audio**: LibGDX audio API
- **Physics**: Custom physics engine with LibGDX integration
- **Data Format**: JSON for levels and configurations

## Component Interactions

### Game Flow
```
Game Loop
├── Input Manager
├── State Manager
├── Game Screen
├── Player System
├── Enemy System
├── Weapon System
├── Level System
├── Collision System
├── Audio System
├── Graphics System
└── UI System
```

### Data Flow
1. Input received → InputManager → Player/Controls
2. Game logic → Update Loop → All Systems
3. Rendering → Graphics System → Display
4. Audio → SoundManager/MusicManager → Output

## Design Patterns Used
1. **State Pattern** - For managing game states (Menu, Playing, Paused, GameOver)
2. **Observer Pattern** - For event handling and notifications
3. **Factory Pattern** - For creating game objects (enemies, projectiles)
4. **Command Pattern** - For player actions and controls
5. **Singleton Pattern** - For managers (Audio, Resources, Input)

## File Structure
```
src/
├── com.metal.slug.game          # Main game logic
├── com.metal.slug.player        # Player system
├── com.metal.slug.enemy       # Enemy system
├── com.metal.slug.weapon      # Weapon system
├── com.metal.slug.level         # Level system
├── com.metal.slug.collision   # Collision system
├── com.metal.slug.audio     # Audio system
├── com.metal.slug.graphics    # Graphics system
├── com.metal.slug.ui          # UI system
├── com.metal.slug.state       # State management
├── com.metal.slug.ai        # AI components
├── com.metal.slug.particle      # Particle effects
├── com.metal.slug.util      # Utility classes
└── com.metal.slug.save        # Save system
```