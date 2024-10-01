package ParkingLotSystem.Strategy;


import ParkingLotSystem.Models.ParkingSpot;

public interface IPricingStrategy {
    double pricingStrategy(ParkingSpot parkingSpot, int hours);
}
