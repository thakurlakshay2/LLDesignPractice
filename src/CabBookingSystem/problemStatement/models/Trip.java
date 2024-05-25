package CabBookingSystem.problemStatement.models;


enum TripStatus{
    IN_PROGRESS,
    FINISHED,
    CANCELLED
}
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location pickUp;
    private Location dropOff;

    public Trip(Rider rider, Cab cab, Double price, Location pickUp, Location dropOff) {
        this.rider = rider;
        this.cab = cab;
        this.tripStatus = TripStatus.IN_PROGRESS;
        this.price = price;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
    }

    public void finishedTripStatus() {
        this.tripStatus = TripStatus.FINISHED;
    }
}

