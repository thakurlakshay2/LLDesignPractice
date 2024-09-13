package CarRentalSystem.Strategy;


import CarRentalSystem.Models.Car;

public class PremiumPricingStrategy implements IPricingStrategy {

    @Override
    public double pricingStrategy(Car car, int hours) {
        return car.getPricingPerHour() * hours * 1.5;
    }
}
