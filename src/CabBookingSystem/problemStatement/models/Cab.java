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

    //setters
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    //getters
    public String getId() {
        return id;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }
}
