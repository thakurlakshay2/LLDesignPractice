package CarRentalSystem.Exceptions;

public class CarNotFoundException  extends RuntimeException{
    public CarNotFoundException(){
        super("Car is not found");
    }

}
