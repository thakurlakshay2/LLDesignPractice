package ParkingLotSystem.Models;

import java.util.List;

public class ParkingFloor {
    private final int name;
    private final List<ParkingSpot>  list;

    public ParkingFloor(int name, List<ParkingSpot> list) {
        this.name = name;
        this.list = list;
    }
}
