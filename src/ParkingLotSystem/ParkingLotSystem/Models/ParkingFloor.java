package ParkingLotSystem.ParkingLotSystem.Models;

import ParkingLotSystem.Models.ParkingSpot;

import java.util.List;

public class ParkingFloor {
    private final int name;
    private final List<ParkingLotSystem.Models.ParkingSpot>  list;

    public ParkingFloor(int name, List<ParkingSpot> list) {
        this.name = name;
        this.list = list;
    }
}
