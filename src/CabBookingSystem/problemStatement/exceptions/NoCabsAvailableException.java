package CabBookingSystem.problemStatement.exceptions;

public class NoCabsAvailableException extends RuntimeException{
    public NoCabsAvailableException() {
        super("No cabs available");
    }
}
