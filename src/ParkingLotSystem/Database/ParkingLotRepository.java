package ParkingLotSystem.Database;

import ParkingLotSystem.Models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ParkingLotRepository {
    private HashMap<String, ParkingLot> parkingLotDB;

    public ParkingLotRepository() {
        this.parkingLotDB = new HashMap<>();
    }

    // Add a parking lot
    public void addParkingLot(String id, ParkingLot parkingLot) {
        parkingLotDB.put(id, parkingLot);
    }

    // Remove a parking lot
    public void removeParkingLot(String id) {
        parkingLotDB.remove(id);
    }

    // Get a list of all parking lots
    public List<ParkingLot> getAllParkingLots() {
        return new ArrayList<>(parkingLotDB.values());
    }
}