# Metal Slug Game Assets Organization

This script organizes downloaded assets into the correct directory structure for the Metal Slug Game project.

## Usage
Run this script after downloading assets to automatically organize them into the correct folders.

## Directory Structure
- `assets/sprites/player/` - Player character sprites
- `assets/sprites/enemies/` - Enemy character sprites  
- `assets/sprites/projectiles/` - Projectile sprites
- `assets/backgrounds/` - Background images
- `assets/ui/` - User interface elements

## Asset Naming Convention
- `player_idle.png` instead of `player_idle_0.png`
- `player_run1.png` instead of `player_walking_0.png`
- `enemy_basic_walk1.png` instead of `enemy_walking_0.png`
- `bullet_player.png` instead of `projectile.png`

## How it works
The script creates the required directory structure and moves downloaded files to their appropriate locations.