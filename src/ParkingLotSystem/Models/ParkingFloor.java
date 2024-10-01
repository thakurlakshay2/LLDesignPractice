package ParkingLotSystem.Models;

import java.util.List;
import java.util.ArrayList;

public class ParkingFloor {
    private final int name;
    private final List<ParkingSpot> list;

    public ParkingFloor(int name, List<ParkingSpot> list) {
        this.name = name;
        this.list = list != null ? list : new ArrayList<>();
    }

    // Getter for name
    public int getName() {
        return name;
    }

    // Getter for list
    public List<ParkingSpot> getParkingSpots() {
        return new ArrayList<>(list); // Return a copy to preserve encapsulation
    }

    // Method to add a parking spot
    public void addParkingSpot(ParkingSpot spot) {
        if (spot != null) {
            list.add(spot);
        }
    }

    // Method to remove a parking spot
    public boolean removeParkingSpot(ParkingSpot spot) {
        return list.remove(spot);
    }

    // Method to get the number of parking spots
    public int getNumberOfSpots() {
        return list.size();
    }
}