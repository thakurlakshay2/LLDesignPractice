package CarRentalSystem.Database;


import CarRentalSystem.Models.Rental;

import java.util.HashMap;
import java.util.Map;

public class RentalRepository {
    private final Map<String, Rental> rentalDb = new HashMap<>();
    public void save(Rental rental) {
        rentalDb.put(rental.getId(), rental);
    }

    public Rental getRentalById(String id) {
        return rentalDb.get(id);
    }
}
