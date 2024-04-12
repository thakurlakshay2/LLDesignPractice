package SnakeLadder.Exceptions;

public class SnakeAlreadyPlacedException extends RuntimeException{
    public SnakeAlreadyPlacedException(int posId) {
        super("Snake is already placed starting at the position "+ posId);
    }
}
