package CarRentalSystem.Exceptions;

public class PaymentFailureException extends RuntimeException{
    public PaymentFailureException(){
        super("Payment Failed Try Again after some time  ");
    }
}
