package CarRentalSystem.Models;

import java.util.Date;


//this is main module concerning the reservation process
public class Booking {
    private final String id;
    private final String carId;
    private final String customerId;
    private final Date startDate;
    private final Date endDate;
    private final double totalCost;

    public Booking(String id, String carId, String customerId, Date startDate, Date endDate, double totalCost) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost=totalCost;
    }

    public String getId() {
        return id;
    }

    public String getCarId() {
        return carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void checkAvailability() {

    }
    public void makeBooking(){

    }

    public void cancelBooking(){

    }
}
