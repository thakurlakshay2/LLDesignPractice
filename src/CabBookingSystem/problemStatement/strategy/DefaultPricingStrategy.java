package CabBookingSystem.problemStatement.strategy;

import CabBookingSystem.problemStatement.models.Location;

public class DefaultPricingStrategy implements PricingStrategy{
    public static final Double PER_KM_RATE=10.0;

    @Override
    public Double findPrice(Location pickup, Location dropoff) {
        return pickup.distance(dropoff)*PER_KM_RATE;
    }
}
