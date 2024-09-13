package CarRentalSystem.Exceptions;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException() {
        super("This slot has already been filled , please select something else");
    }
}
