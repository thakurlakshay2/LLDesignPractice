package CabBookingSystem.problemStatement.exceptions;

public class RidersAlreadyExistsException extends RuntimeException{
    public RidersAlreadyExistsException(){
        super("This rider already exists");
    }
}
