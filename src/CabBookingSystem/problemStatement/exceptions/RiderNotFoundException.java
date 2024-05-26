package CabBookingSystem.problemStatement.exceptions;

public class RiderNotFoundException extends RuntimeException {
    public RiderNotFoundException(){
        super("Rider Not Found");
    }
}
