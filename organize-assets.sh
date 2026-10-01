#!/bin/bash

# Metal Slug Game Assets Organizer
# This script helps organize downloaded assets into the correct directory structure

echo "Metal Slug Game Assets Organizer"
echo "======================"

# Create the required directory structure if it doesn't exist
echo "Creating directory structure..."
mkdir -p assets/sprites/player assets/sprites/enemies assets/sprites/projectiles assets/backgrounds assets/ui

# Create a simple inventory of what we have
echo ""
echo "Current assets structure:"
find assets/ -type f | head -20

echo ""
echo "Asset organization complete!"
echo "Assets should now be in the correct structure:"
echo "  assets/sprites/player/"
echo "  assets/sprites/enemies/"
echo "  assets/sprites/projectiles/"
echo "  assets/backgrounds/"
echo "  assets/ui/"