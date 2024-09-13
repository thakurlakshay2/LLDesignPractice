package CarRentalSystem.Strategy;


import CarRentalSystem.Models.Car;

public class DefaultPricingStrategy implements IPricingStrategy {

    @Override
    public double pricingStrategy(Car car, int hours) {
        return car.getPricingPerHour() * hours;
    }
}
