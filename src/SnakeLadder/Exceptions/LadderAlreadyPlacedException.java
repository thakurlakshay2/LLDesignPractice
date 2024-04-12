package SnakeLadder.Exceptions;

public class LadderAlreadyPlacedException extends RuntimeException{

    public LadderAlreadyPlacedException(int endId) {
        super("Ladder already Placed at the position "+endId);
    }
}
