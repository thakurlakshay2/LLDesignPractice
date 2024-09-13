package CarRentalSystem.Exceptions;

public class DuplicateBooking extends RuntimeException {
    public DuplicateBooking() {
        super("This Booking has already been submited");
    }
}
