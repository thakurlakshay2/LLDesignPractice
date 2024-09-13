package CarRentalSystem.Strategy;

import CarRentalSystem.Models.Car;

public interface IPricingStrategy {
    double pricingStrategy(Car car, int hours);
}
