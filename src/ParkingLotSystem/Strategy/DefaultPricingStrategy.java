package ParkingLotSystem.Strategy;


import ParkingLotSystem.Models.ParkingSpot;

public class DefaultPricingStrategy implements IPricingStrategy {

    @Override
    public double pricingStrategy(ParkingSpot parkingSpot, int hours) {
        return parkingSpot.getPricingPerHour() * hours;
    }
}
