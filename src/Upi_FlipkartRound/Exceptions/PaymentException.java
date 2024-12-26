package Upi_FlipkartRound.Exceptions;

public class PaymentException extends RuntimeException{
    public PaymentException(String message) {
        super(message);
    }
}
