package ParkingLotSystem.ParkingLotSystem.Exceptions;

public class ParkingFullException extends RuntimeException {
    public ParkingFullException(String message) {
        super(message);
    }
}
