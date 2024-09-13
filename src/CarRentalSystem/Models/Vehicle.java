package CarRentalSystem.Models;

public class Vehicle {
    private final String id;
    private final String brand;
    private final String model;
    private final String color;
    private final int year;
    private  boolean available;
    private final int regNo;
    private double pricingPerHour;


    public void displayInfo() {
        System.out.println("Make: " + brand);
        System.out.println("Model " + model);
        System.out.println("Year: " + year);
        System.out.println("Rental Rate: " + pricingPerHour);
    }

    public Vehicle(String id, String brand, String model, String color, int year, int regNo) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.regNo = regNo;
        this.available=true;
        this.pricingPerHour=0;

    }


    public String getId() {
        return this.id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void updateAvailability(boolean availability){
        if(availability==this.available){
//            throw AlreadyBookedError;
        }else{
            this.available=availability;
        }

    }

    public void addPricingPerHour(double price){
        this.pricingPerHour=price;
    }
    public double getPricingPerHour(){
        return this.pricingPerHour;
    }
}
