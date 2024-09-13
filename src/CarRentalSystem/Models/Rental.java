package CarRentalSystem.Models;


//Comes into play after booking has been confirmed
public class Rental {
    private final String id;
    private final int bookingId;
    private final Double totalCost;
    private final boolean isJourneyComplete;

    public Rental(String id, int bookingId, Double totalCost) {
        this.id = id;
        this.bookingId = bookingId;
        this.totalCost = totalCost;
        this.isJourneyComplete=false;
    }

    public String getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Double getTotalCost() {
        //cost engine
        return totalCost;
    }

    public int calculateCost(){
        return 0;
    }
    public String generateInvoice(){
        return "daoidjawiodjw";
    }
    public void makeCarUnavailabe(Car car) {
        car.updateAvailability(false);
    }

    public void makeCarAvailable(Car car){
        car.updateAvailability(true);
    }
}
