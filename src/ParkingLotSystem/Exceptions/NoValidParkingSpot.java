package ParkingLotSystem.Exceptions;

public class NoValidParkingSpot extends RuntimeException {
    public NoValidParkingSpot(String message) {
        super(message);
    }
}
