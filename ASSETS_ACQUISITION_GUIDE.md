# Metal Slug Game Assets Acquisition Guide

## Project Overview

This is a Metal Slug-style 2D platformer game built with LibGDX. The game requires specific assets organized in a particular structure to function correctly.

## Problem Statement

You need to acquire game assets that are:
1. Unique (not copied from existing Metal Slug games)
2. Free for commercial use
3. Properly formatted for LibGDX
4. Able to be published without licensing issues

## Solution Approach

### Step 1: Obtain Free Assets from Recommended Sources

1. **Kenney.nl** - https://kenney.nl/assets
   - Download "Platformer Characters" pack
   - Download "New Platformer Pack" for backgrounds
   - Download "UI Pack" for health bars and menus

2. **OpenGameArt.org** - https://opengameart.org
   - Search for "platformer" or "pixel art"
   - Find assets with CC0 or CC-BY licenses

3. **Itch.io** - https://itch.io/game-assets
   - Look in the free assets section

### Step 2: Asset Requirements

All assets must meet these requirements:
- PNG format with transparency support
- Proper sizing (32x32 to 64x64 pixels for sprites)
- Free for commercial use (CC0 license preferred)
- Proper naming conventions (matching the code structure)

### Step 3: Asset Organization

Create the following directory structure:
```
assets/
├── sprites/
│   ├── player/
│   ├── enemies/
│   ├── projectiles/
│   └── background/
```

### Step 4: Asset Naming Convention

Based on the existing code in Game.java, assets should be named:
- Player: `player_*.png` (player_idle.png, player_run1.png, player_shoot.png)
- Enemies: `enemy_*.png` (enemy_basic_walk1.png, enemy_basic_attack.png)
- Projectiles: `bullet_*.png` (bullet_player.png, bullet_enemy.png)

### Step 5: Publication Safety

To ensure your game can be published:
1. Only use assets that are clearly free for commercial use
2. Avoid copying exact designs from existing games
3. Create unique character designs or use different color palettes
4. Make sure all assets have proper licensing information

## Implementation Steps

1. **Download Free Assets**:
   - Go to Kenney.nl and download the Platformer Characters pack
   - Download the New Platformer Pack for backgrounds
   - Download UI Pack for menus and HUD elements

2. **Organize Assets**:
   - Extract downloaded assets to the appropriate directories
   - Rename files to match the expected naming convention
   - Ensure all PNG files have transparency

3. **Test Assets**:
   - Run the game to verify assets load correctly
   - Check that all animations work properly
   - Verify there are no missing asset errors

## Recommended Assets to Download

### Character Sprites (Player)
- Character sprites with idle, running, jumping, shooting animations
- Size: 32x48 or 32x32 pixels
- Multiple frames for animations

### Enemy Sprites
- Different enemy types with walking, attacking, dying animations
- Size: 32x32 pixels
- At least 4 frames per animation state

### Projectile Sprites
- Bullet sprites (player and enemy)
- Explosion effects
- Size: 8x8 to 16x16 pixels

### Background Elements
- Tilesets for level backgrounds
- Background images for different levels
- Size: 800x600 pixels or larger

## License Compliance

All assets must be:
1. Free for commercial use
2. CC0 license or similar permissive license
3. Clearly marked for reuse in commercial projects
4. Not copied from existing published games

This approach will ensure that your game has unique, publication-ready assets that meet the technical requirements of the LibGDX framework while avoiding potential licensing conflicts.