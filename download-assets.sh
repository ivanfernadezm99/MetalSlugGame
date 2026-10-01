#!/bin/bash

# Script para descargar assets de juegos para Metal Slug Game
# Este script prepara la estructura de directorios y documenta los pasos necesarios para descargar assets

echo "Preparando estructura de directorios para assets..."
mkdir -p /home/servidor/Descargas/MetalSlugGame/assets/sprites/player
mkdir -p /home/servidor/Descargas/MetalSlugGame/assets/sprites/enemies
mkdir -p /home/servidor/Descargas/MetalSlugGame/assets/sprites/projectiles
mkdir -p /home/servidor/Descargas/MetalSlugGame/assets/backgrounds
mkdir -p /home/servidor/Descargas/MetalSlugGame/assets/ui

echo "Estructura de directorios creada:"
echo "  /home/servidor/Descargas/MetalSlugGame/assets/sprites/player/"
echo "  /home/servidor/Descargas/MetalSlugGame/assets/sprites/enemies/"
echo "  /home/servidor/Descargas/MetalSlugGame/assets/sprites/projectiles/"
echo "  /home/servidor/Descargas/MetalSlugGame/assets/backgrounds/"
echo "  /home/servidor/Descargas/MetalSlugGame/assets/ui/"

echo ""
echo "Para descargar los assets reales, necesitas:"
echo "1. Visitar: https://kenney.nl/assets"
echo "   - Descargar: Platformer Characters"
echo "   - Descargar: New Platformer Pack" 
echo "   - Descargar: UI Pack"
echo ""
echo "2. Visitar: https://opengameart.org"
echo "   - Buscar: platformer o pixel art"
echo "   - Filtrar por licencia: CC0 o CC-BY"
echo ""
echo "3. Visitar: https://itch.io/game-assets"
echo "   - Buscar: free, platformer o pixel art"
echo "   - Verificar licencia comercial"
echo ""
echo "4. Una vez descargados, organizar los archivos:"
echo "   - Sprites de jugador: /home/servidor/Descargas/MetalSlugGame/assets/sprites/player/"
echo "   - Sprites de enemigos: /home/servidor/Descargas/MetalSlugGame/assets/sprites/enemies/"
echo "   - Sprites de proyectiles: /home/servidor/Descargas/MetalSlugGame/assets/sprites/projectiles/"
echo "   - Fondos: /home/servidor/Descargas/MetalSlugGame/assets/backgrounds/"
echo "   - Elementos de UI: /home/servidor/Descargas/MetalSlugGame/assets/ui/"
echo ""
echo "Los archivos deben tener nombres específicos:"
echo "   - player_idle.png en lugar de player_idle_0.png"
echo "   - player_run1.png en lugar de player_walking_0.png"
echo "   - enemy_basic_walk1.png en lugar de enemy_walking_0.png"
echo "   - bullet_player.png en lugar de projectile.png"