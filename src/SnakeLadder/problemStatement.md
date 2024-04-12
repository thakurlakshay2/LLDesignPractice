# Snake and Ladder Application

## Problem Statement

Create a snake and ladder application. The application should take as input:

- Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
- Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
- Number of players (p) followed by p lines each containing a name.

After taking these inputs, the application should simulate the game by printing all the moves in the following format:
- <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>

When someone wins the game, print that the player won the game in the following format:
- <player_name> wins the game

## Rules of the game

- The board will have 100 cells numbered from 1 to 100.
- The game will have a six-sided dice numbered from 1 to 6.
- Each player has a piece which is initially kept outside the board (i.e., at position 0).
- Each player rolls the dice when their turn comes.
- Based on the dice value, the player moves their piece forward that number of cells.
- A player wins if they exactly reach position 100.
- If a piece is supposed to move outside position 100, it does not move.
- The board also contains some snakes and ladders.
- Whenever a piece ends up at a position with the head of the snake, it goes down to the position of the tail of that snake.
- Whenever a piece ends up at a position with the start of the ladder, it goes up to the position of the end of that ladder.

## Assumptions

- There won’t be a snake at 1 00.
- There won’t be multiple snakes/ladders at the same start/head point.
- It is possible to reach 100.
- Snakes and Ladders do not form an infinite loop.

## Expectations

- The code should be working and demonstrable.
- The code should be functionally correct.
- Code should be modular and readable.
- Separation of concern should be addressed.
- There should be a main method for easy testing.
- Optional: Write unit tests.
- No need for a GUI.

## Optional Requirements

- The game can be played with two dice instead of 1.
- The board size can be customizable.
- In case of more than 2 players, the game continues until only one player is left.
- On getting a 6, you get another turn.
- On getting 3 consecutive 6s, all the three of those get cancelled.
- Snakes and ladders should be created programmatically at the start of the application.
 



