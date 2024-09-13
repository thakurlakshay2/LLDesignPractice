package CarRentalSystem.Models;

import java.util.Date;

public class Payment {
    private final int id;
    private final int rentalId;
    private final Double paymentAmount;
    private final Date paymentDate;
    private final String paymentGateway;
    private  String paymentStatus;

    public Payment(int id, int rentalId, Double paymentAmount, Date paymentDate, String paymentGateway, String paymentStatus) {
        this.id = id;
        this.rentalId = rentalId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentGateway = paymentGateway;
        this.paymentStatus = paymentStatus;
    }

    public String viewPayment(){
        return this.paymentStatus;
    }
    public void makePayment() {

        //payment logic
    }
    public void refundPayment() {


        //runner logic
    }
    public void displayError(){
       //return error here
    }
}
