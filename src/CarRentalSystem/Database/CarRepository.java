package CarRentalSystem.Database;


import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private final Map<String, Car> carDB = new HashMap<>();
    private final Map<String, List<Booking>> carBookingDb=new HashMap<>();

    public void save(Car car) {

        carDB.put(car.getId(), car);
        carBookingDb.put(car.getId(),new ArrayList<>());
    }

    public Car getCarById(String id) {
        return carDB.get(id);
    }
    public void remove(Car car){
        carDB.remove(car.getId());
    }

    public List<Booking> getcarBookingList(Car car){
        return carBookingDb.get(car.getId());
    }

    public void addCarBooking(Car car, Booking booking){
        carBookingDb.get(car.getId()).add(booking);
    }
}

