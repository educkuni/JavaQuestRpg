# 🗡️ JavaQuest CLI

An interactive, turn-based Command Line Interface (CLI) RPG built in Java. It features complete Object-Oriented Programming (OOP) concepts, combat mechanics, random dungeon encounters, and persistent state saving using Google's Gson.

## 🚀 Features
- **Hero Creation & Classes:** Choose between Warrior, Mage, or Archer—each with unique HP, Mana, Attack, and Defense scaling.
- **Turn-Based Combat:** Fight random monsters (Goblins, Orcs, Skeletons) with options to Attack, use Special Abilities, or drink Health Potions.
- **Progression System:** Earn XP from battles to level up and increase your base attributes automatically.
- **Save & Load System:** Save your game state at any point into a local `savegame.json` file using Gson, allowing seamless continuation.

## 🛠️ Tech Stack & Dependencies
- **Language:** Java 17+
- **IDE:** IntelliJ IDEA
- **JSON Serialization:** Google Gson 2.10.1
- **Build Tool / Dependency Management:** Maven

## 📁 Project Structure
```text
src/
├── GameApp.java       # Main entry point, menus, and game loop
├── Hero.java          # Player character state, leveling, and skill mechanics
├── Monster.java       # Enemy attributes and damage calculation
└── SaveManager.java   # JSON persistence (File I/O with Gson)

How to Run
Clone this repository.

Open the project in IntelliJ IDEA (or any Java IDE).

Ensure the gson dependency is synced via Maven (pom.xml).

Run GameApp.java.

=================================
      🗡️  JAVA QUEST CLI  🛡️     
=================================
1. New Game
2. Load Game
Choose an option: 1

--- CREATE YOUR HERO ---
Enter hero name: Arthur
Choose class:
1. Warrior (High HP & Defense)
2. Mage (High Attack & Mana)
3. Archer (Balanced)
Option: 1

✨ Welcome, Arthur the Warrior!

---------------------------------
Hero: Arthur | Level: 1 | HP: 120/120 | Mana: 30/30 | Potions: 3
---------------------------------
1. Explore Dungeon (Battle)
2. Rest at Inn (Heal)
3. Save Game
4. Exit Game
