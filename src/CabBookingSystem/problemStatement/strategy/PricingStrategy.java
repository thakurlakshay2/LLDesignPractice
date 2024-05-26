package CabBookingSystem.problemStatement.strategy;

import CabBookingSystem.problemStatement.models.Location;

public interface PricingStrategy {
    Double findPrice(Location pickup, Location dropoff);
}
