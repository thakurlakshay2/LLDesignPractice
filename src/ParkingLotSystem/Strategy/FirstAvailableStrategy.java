package ParkingLotSystem.Strategy;

import ParkingLotSystem.Exceptions.NoValidParkingSpot;
import ParkingLotSystem.Models.*;
import java.util.List;
import java.util.stream.Collectors;

public class FirstAvailableStrategy implements IFindingParkingSpotStrategy {
    @Override
    public ParkingSpot parkingSortStrategy(ParkingLot parkingLot, Vehicle vehicle) throws  NoValidParkingSpot {
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloors();

        for (ParkingFloor parkingFloor : parkingFloorList) {
            List<ParkingSpot> validSpots = getValidParkingSpots(parkingFloor, vehicle);
            if (!validSpots.isEmpty()) {
                return validSpots.get(0); // Return the first valid spot
            }
        }
        throw  new NoValidParkingSpot("No Spot found for Vehicle:"+ vehicle.getLicenceNo());
         // No valid spot found
    }

    private List<ParkingSpot> getValidParkingSpots(ParkingFloor parkingFloor, Vehicle vehicle) {
        return parkingFloor.getParkingSpots().stream()
                .filter(spot -> spot.isFree() && vehicle.canFitInSpot(spot.getType()))
                .collect(Collectors.toList());
    }
}