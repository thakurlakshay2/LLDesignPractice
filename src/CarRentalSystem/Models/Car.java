package CarRentalSystem.Models;

public class Car extends  Vehicle {
    private int numDoors;
    private int isConvertable;
    private String fuelType;

    public Car(String id, String brand, String model, String color, int year , int regNo,int numDoors,int isConvertable,String fuelType) {
        super(id,brand,model,color,year,regNo);
        this.numDoors=numDoors;
        this.isConvertable=isConvertable;
        this.fuelType=fuelType;

    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of doors: "+ numDoors);
        System.out.println("Convertible : "+ isConvertable);
        System.out.println("Fuel Type: "+ fuelType);
    }
}
