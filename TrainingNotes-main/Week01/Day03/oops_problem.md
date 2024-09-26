### **Console-Based Game Problem: Dungeon Adventure**

#### **Problem Description:**

Create a console-based game called "Dungeon Adventure" where a player explores a dungeon, encounters various creatures, and collects treasures. The game should utilize inheritance, polymorphism, and abstraction.

#### **Requirements:**

1.  **Base Classes and Interfaces:**

    -   Create an abstract class `Creature` with common properties (e.g., name, health) and abstract methods (e.g., `attack`, `takeDamage`).
    -   Create an interface `Interactable` with a method `interact`.
2.  **Player and Enemy Classes:**

    -   Create a `Player` class that inherits from `Creature` and implements `Interactable`.
    -   Create at least two different enemy classes (e.g., `Goblin`, `Dragon`) that inherit from `Creature` and implement `Interactable`.
3.  **Item Classes:**

    -   Create an abstract class `Item` with a property `name` and an abstract method `use`.
    -   Create specific item classes (e.g., `Potion`, `Weapon`) that inherit from `Item`.
4.  **Game Mechanics:**

    -   The player can move through different rooms in the dungeon.
    -   Each room may contain enemies or items.
    -   The player can interact with enemies (e.g., fight) and items (e.g., pick up and use).
    -   Implement a simple combat system where the player can attack enemies and take damage.
5.  **Polymorphism:**

    -   Use polymorphism to handle different types of creatures and items uniformly.
6.  **Game Loop:**

    -   Implement a main game loop that allows the player to explore the dungeon until they exit or are defeated.