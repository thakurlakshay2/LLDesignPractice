package ParkingLotSystem.Models;

public class Vehicle {
    private final String licenceNo;
    private final VehicleType type;
    private  ParkingTicket parkingTicket;

    public Vehicle(String licenceNo, VehicleType type,ParkingTicket parkingTicket) {
        this.licenceNo = licenceNo;
        this.type = type;
        this.parkingTicket=parkingTicket;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public  boolean canFitInSpot(ParkingSpotType spotType) {

        switch (this.type) {
            case Car:
                return spotType == ParkingSpotType.Compact || spotType == ParkingSpotType.Large;
            case Motorbike:
                return true; // Can fit in any spot
            case Truck:
                return spotType == ParkingSpotType.Large;
            case Electric:
                return spotType == ParkingSpotType.Electric || spotType == ParkingSpotType.Compact || spotType == ParkingSpotType.Large;
            case Van:
                return spotType == ParkingSpotType.Handicapped || spotType == ParkingSpotType.Large;
            default:
                return false;
        }
    }

}
