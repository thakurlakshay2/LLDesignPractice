package CabBookingSystem.problemStatement.exceptions;

public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException() {
        super("Trip not found");
    }
}
