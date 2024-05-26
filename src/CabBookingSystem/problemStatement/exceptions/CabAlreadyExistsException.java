package CabBookingSystem.problemStatement.exceptions;

public class CabAlreadyExistsException extends  RuntimeException{

    public CabAlreadyExistsException(){
        super("Cab already exists ");
    }
}
