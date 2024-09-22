package ParkingLotSystem.Models;

public class ParkingSpot {
    private final int number;
    private  ParkingSpotType type;
    private  Vehicle vehicle;
    private boolean isFree;

    public ParkingSpot(int number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
        this.isFree=true;
    }


}
