package CarRentalSystem.Exceptions;

public class BookingException extends  RuntimeException{
    public BookingException(){
        super("No Booking Details Found.");
    }

}
