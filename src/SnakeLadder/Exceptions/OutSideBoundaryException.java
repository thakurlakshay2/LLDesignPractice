package SnakeLadder.Exceptions;

public class OutSideBoundaryException extends  RuntimeException{
    public OutSideBoundaryException() {
        super("Adding Value Outside boundary is not allowed");
    }
}
