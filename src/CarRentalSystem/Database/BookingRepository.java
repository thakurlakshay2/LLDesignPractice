package CarRentalSystem.Database;

import CarRentalSystem.Models.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private final Map<String, Booking> bookingDB = new HashMap<>();

    public void save(Booking booking) {
        bookingDB.put(booking.getId(), booking);
    }

    public Booking getBookingById(String id) {
        return bookingDB.get(id);
    }

    public void remove(Booking booking){
        bookingDB.remove(booking.getId());
    }


    public void cancelBooking(Booking booking){
        remove(booking);
        //refund payment process
    }
}
