package ParkingLotSystem.Strategy;

import ParkingLotSystem.Models.ParkingSpot;
import ParkingLotSystem.Models.ParkingSpotType;

public class PremiumPricingStrategy implements IPricingStrategy {

    private double multiplier(ParkingSpotType parkingSpotType){
        switch (parkingSpotType){
            case Large -> {
                return 2;
            }
            case Compact -> {
                return 1.3;
            }
            case Electric -> {
                return 1.2;
            }
            case Motorbike -> {
                return 1.1;
            }
            default -> {
                return 1;
            }
        }
    }
    @Override
    public double pricingStrategy(ParkingSpot parkingSpot, int hours) {
        return parkingSpot.getPricingPerHour() * hours * multiplier(parkingSpot.getType());
    }
}
