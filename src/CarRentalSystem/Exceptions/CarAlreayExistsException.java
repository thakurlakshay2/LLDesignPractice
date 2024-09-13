package CarRentalSystem.Exceptions;

public class CarAlreayExistsException extends RuntimeException {
    public CarAlreayExistsException() {
        super("This Car Already Exists");
    }
}
