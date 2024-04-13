# Tic Tac Toe Low-Level Design

## Problem Statement

You are tasked with designing the low-level structure for a Tic Tac Toe game. The game should allow two players to take turns marking spaces on a 3x3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game. The game should also be able to detect a tie if all spaces on the grid are filled without a winner.

Your task is to design the classes, methods, and data structures necessary to implement this game. Consider the following aspects in your design:

1. **Board Representation**: How will you represent the 3x3 grid? What data structure(s) will you use to store the current state of the board?

2. **Player Representation**: How will you represent the players? What attributes and methods should the Player class have?

3. **Game Logic**: How will you handle the game logic, including determining if a player has won, if the game is a tie, and validating player moves?

4. **User Interface**: While this is a low-level design, consider how the game will interact with users. Will you have a command-line interface or a graphical user interface? How will users input their moves?

5. **Scalability and Extensibility**: Consider how your design could be extended to support variations of Tic Tac Toe, such as larger boards or different win conditions.

Your design should be modular, easy to understand, and flexible enough to accommodate future changes or additions. You don't need to implement the actual game logic in code, but you should provide a clear outline of the classes, methods, and interactions necessary for the game to function.

## Constraints

- The grid size will always be 3x3.
- There will be two players taking turns.
- Moves must be valid (i.e., players cannot overwrite each other's marks or make moves on already filled spaces).
- The game should accurately determine if a player has won, if the game is a tie, or if it's still ongoing.
- The design should be object-oriented and follow best practices for code organization and readability.
