package CabBookingSystem.problemStatement.models;

public class Cab {
    String id;
    String driverName;

    Trip currentTrip;
    Location currentLocation;
    Boolean isAvailable;
    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable=true;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
