package CarRentalSystem.Exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException() {
        super("Customer Already Exists");
    }
}
