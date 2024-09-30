package ParkingLotSystem.ParkingLotSystem.Models;

import ParkingLotSystem.Models.Location;
import ParkingLotSystem.Models.ParkingFloor;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final String id;
    private final ParkingLotSystem.Models.Location location;
    private int floors;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String id, ParkingLotSystem.Models.Location location) {
        this.id = id;
        this.location = location;
        this.floors = 0;
        this.parkingFloors = new ArrayList<>();
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Getter for location
    public Location getLocation() {
        return location;
    }

    // Getter for floors
    public int getFloors() {
        return floors;
    }

    // Setter for floors
    public void setFloors(int floors) {
        this.floors = floors;
    }

    // Getter for parkingFloors
    public List<ParkingFloor> getParkingFloors() {
        return new ArrayList<>(parkingFloors);
    }

    // Method to add a parking floor
    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.add(parkingFloor);
        this.floors = this.parkingFloors.size();
    }
}