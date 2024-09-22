package ParkingLotSystem.Models;

public class Location {
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zipcode;
    private final String country;


    public Location(String streetAddress, String city, String state, String zipcode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }
}
