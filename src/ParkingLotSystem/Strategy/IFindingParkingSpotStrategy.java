package ParkingLotSystem.Strategy;


import ParkingLotSystem.Exceptions.NoValidParkingSpot;
import ParkingLotSystem.Models.ParkingLot;
import ParkingLotSystem.Models.ParkingSpot;
import ParkingLotSystem.Models.Vehicle;

public interface IFindingParkingSpotStrategy {
    ParkingSpot parkingSortStrategy(ParkingLot parkingLot, Vehicle vehicle) throws NoValidParkingSpot;
}
