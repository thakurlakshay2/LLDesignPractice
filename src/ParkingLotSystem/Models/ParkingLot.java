package ParkingLotSystem.Models;

public class ParkingLot {
    private final String id;
    private final Location location;
    private final int floors;

    public ParkingLot(String id, Location location) {
        this.id = id;
        this.location = location;
        floors=0;
    }
}
