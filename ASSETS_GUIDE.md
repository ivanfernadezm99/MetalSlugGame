# Metal Slug Game Assets Documentation

## Overview
This document describes the sprite asset structure needed for the Metal Slug Clone game.

## Required Asset Categories

### 1. Player Assets
- **Player character sprites**: Walking, idle, jumping, shooting animations
- File naming: `player_*.png` (e.g., player_idle.png, player_run1.png, player_shoot.png)

### 2. Enemy Assets
- **Basic enemy sprites**: Walking, idle, attacking, dying animations
- **Special enemy sprites**: Different enemy types with unique sprites
- File naming: `enemy_basic_*.png`, `enemy_special_*.png`

### 3. Projectile Assets
- **Bullet sprites**: Player bullets, enemy bullets
- **Explosion sprites**: Projectile impact effects
- File naming: `bullet_*.png`, `explosion_*.png`

### 4. UI Assets
- **Button sprites**: On-screen controls
- **Health bar**: Player health indicator
- **Score display**: Game score elements
- File naming: `button_*.png`, `health_bar_*.png`

## Asset Requirements

### File Format
- **Format**: PNG files with transparency support
- **Size**: 32x32 to 64x64 pixels (standard for 2D games)
- **Color depth**: 32-bit with alpha channel

### Organization
```
assets/
├── sprites/
│   ├── player/
│   │   ├── player_idle.png
│   │   ├── player_run1.png
│   │   ├── player_run2.png
│   │   └── player_shoot.png
│   ├── enemies/
│   │   ├── enemy_basic_idle.png
│   │   ├── enemy_basic_walk1.png
│   │   ├── enemy_basic_walk2.png
│   │   └── enemy_basic_attack.png
│   ├── projectiles/
│   │   ├── bullet_player.png
│   │   └── bullet_enemy.png
│   ├── ui/
│   │   ├── button_jump.png
│   │   ├── button_attack.png
│   │   └── health_bar.png
│   └── background/
│       ├── background_tile1.png
│       └── background_tile2.png
```

## Free Asset Resources

### Recommended Sources:
1. **Kenney.nl** - Free game assets (https://kenney.nl/assets)
2. **OpenGameArt.org** - Community-created assets (https://opengameart.org)
3. **Itch.io** - Free assets section (https://itch.io/game-assets)
4. **LibGDX Assets** - Official LibGDX asset packs

## Asset Creation Tips

### For Metal Slug Style:
- Pixel art style with clean lines
- Consistent character proportions
- Clear visual distinction between player and enemies
- Animated sprites with proper frame sequences
- Consider using sprite sheets for efficiency

### Best Practices:
- Use consistent naming conventions
- Maintain uniform sprite sizes within categories
- Include animation frames as separate files
- Provide fallback sprites for missing assets
- Test with different resolutions

## Integration Notes

The game code expects assets to be loaded from the `assets/` directory structure. The ResourceManager class handles loading these assets with the following typical patterns:

```java
// Loading player sprites
Texture playerTexture = new Texture("sprites/player/player_idle.png");

// Loading multiple animation frames
Array<Texture> playerAnimation = new Array<Texture>();
playerAnimation.add(new Texture("sprites/player/player_run1.png"));
playerAnimation.add(new Texture("sprites/player/player_run2.png"));
```

## Testing Assets

To verify assets work correctly:
1. Ensure all PNG files are valid
2. Test that sprite loading doesn't cause errors
3. Verify animations play correctly
4. Confirm UI elements display properly