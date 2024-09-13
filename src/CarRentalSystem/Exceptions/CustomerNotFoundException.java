package CarRentalSystem.Exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(){
        super("Customer is not found");
    }

}
