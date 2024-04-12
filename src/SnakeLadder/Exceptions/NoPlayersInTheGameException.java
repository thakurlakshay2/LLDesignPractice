package SnakeLadder.Exceptions;

public class NoPlayersInTheGameException extends RuntimeException{
    public NoPlayersInTheGameException() {
        super("No players found in the game");
    }
}
