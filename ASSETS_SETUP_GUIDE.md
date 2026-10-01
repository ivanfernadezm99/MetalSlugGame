# Metal Slug Game Assets Setup Plan

## Overview
This document provides instructions for setting up unique game assets for your Metal Slug-style platformer game that will be acceptable for publication.

## Recommended Asset Sources

### 1. Kenney.nl (Primary Source)
- **Platformer Characters**: Contains character sprites with multiple animations
- **New Platformer Pack**: Includes background tiles and level design elements
- **UI Pack**: For health bars, menus, and other UI elements
- **All assets are CC0 licensed** (free for commercial use)

### 2. OpenGameArt.org
- **Platformer Art Complete Pack**: Collection of sprites with various animations
- **LPC (Libre Pixel Characters)**: Various character types
- **Dungeon Crawl 32x32 tiles**: For level design elements

## Asset Directory Structure
Create the following directory structure in your assets folder:
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
│   └── background/
│       ├── background_tile1.png
│       └── background_tile2.png
```

## Steps to Get Assets

1. **Download from Kenney.nl**:
   - Visit: https://kenney.nl/assets
   - Search for "Platformer Characters" 
   - Download the complete pack
   - Extract the PNG files to the appropriate directories

2. **Download from OpenGameArt.org**:
   - Visit: https://opengameart.org
   - Search for "platformer" or "pixel art"
   - Find assets with CC0 or similar licenses
   - Download and extract to the appropriate directories

3. **Organize Files**:
   - Move player sprites to `assets/sprites/player/`
   - Move enemy sprites to `assets/sprites/enemies/`
   - Move projectile sprites to `assets/sprites/projectiles/`
   - Move background tiles to `assets/backgrounds/`

## Important Notes for Publication

1. **Unique Assets**: Ensure that all assets are either:
   - Created by you from scratch, or
   - Downloaded from free sources with proper licensing (CC0, CC-BY, etc.)

2. **Avoid Direct Copies**: Do not copy assets directly from existing Metal Slug games or similar titles.

3. **License Compliance**: All assets must be free for commercial use.

4. **File Format**: All sprites must be in PNG format with transparency support.

## Asset Requirements

1. **Sprite Size**: 32x32 to 64x64 pixels
2. **Color Depth**: 32-bit with alpha channel
3. **Format**: PNG with transparency
4. **Naming Convention**: Follow the exact naming pattern used in the code
5. **Animation Frames**: Separate files for each animation frame

## Testing Your Assets

After downloading and organizing the assets:
1. Run the game to ensure assets load correctly
2. Check that all sprites display properly
3. Verify that animations work correctly
4. Ensure there are no missing files that would cause errors

## Next Steps

1. Create a directory to store downloaded assets temporarily
2. Download the recommended assets from the sources above
3. Organize them according to the structure above
4. Test that they load correctly in your game

This approach ensures you'll have unique, publication-ready assets for your Metal Slug game.